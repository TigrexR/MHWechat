package com.tigrex.mh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemMenuBO;
import com.tigrex.mh.entity.bo.SystemResourceBO;
import com.tigrex.mh.entity.po.SystemMenu;
import com.tigrex.mh.entity.query.SystemMenuQuery;
import com.tigrex.mh.mapper.SystemMenuMapper;
import com.tigrex.mh.service.ISystemMenuService;
import com.tigrex.mh.service.ISystemResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author linus
 */
@Service(value = "systemMenuService")
public class SystemMenuServiceImpl implements ISystemMenuService {

    @Autowired
    private SystemMenuMapper mapper;
    @Autowired
    private ISystemResourceService systemResourceService;
    
    @Override
    public Integer saveOrUpdate(SystemMenuBO data) {
        SystemMenu menu = mapper.selectOne(new LambdaQueryWrapper<SystemMenu>().eq(SystemMenu::getCode, data.getCode()));
        if (menu != null) {
            return mapper.update(JacksonUtils.getJackson().convertValue(data, SystemMenu.class),
                    new LambdaUpdateWrapper<SystemMenu>().func(u -> {
                        u.eq(SystemMenu::getCode, data.getCode());
                        if (data.getCode() != null) {
                            u.set(SystemMenu::getCode, data.getCode());
                        }
                        if (data.getName() != null) {
                            u.set(SystemMenu::getName, data.getName());
                        }
                        if (data.getParentCode() != null) {
                            u.set(SystemMenu::getParentCode, data.getParentCode());
                        }
                        if (data.getResourceCode() != null) {
                            u.set(SystemMenu::getResourceCode, data.getResourceCode());
                        }
                        if (data.getMark() != null) {
                            u.set(SystemMenu::getMark, data.getMark());
                        }
                    }));
        } else {
            return mapper.insert(JacksonUtils.getJackson().convertValue(data, SystemMenu.class));
        }
    }

    @Override
    public Integer remove(SystemMenuQuery query) {
        return mapper.delete(new LambdaQueryWrapper<SystemMenu>().func(d -> d.eq(SystemMenu::getCode, query.getCode())));
    }

    @Override
    public SystemMenuBO get(SystemMenuQuery query) {
        return null;
    }

    @Override
    public List<SystemMenuBO> list(SystemMenuQuery query) {
        return null;
    }

    @Override
    public Page<SystemMenuBO> page(SystemMenuQuery query) {
        return null;
    }

    @Override
    public List<SystemMenuBO> selectMenusByRoleCodes(List<String> roleCodes) {
        List<SystemMenuBO> menus = JacksonUtils.getJackson().convertValue(mapper.selectMenusByRoleCodes(roleCodes),
                new TypeReference<List<SystemMenuBO>>() {});
        List<SystemResourceBO> resources = systemResourceService.listResourcesByCode(
                menus.stream().map(SystemMenuBO::getResourceCode).collect(Collectors.toList()));
        menus.forEach(menu -> {
            SystemResourceBO resource = resources.stream().filter(item -> item.getCode().equals(menu.getResourceCode()))
                    .findFirst().orElse(new SystemResourceBO());
            menu.setType(resource.getType()).setUrl(resource.getUrl());
        });
        return menus;
    }
}
