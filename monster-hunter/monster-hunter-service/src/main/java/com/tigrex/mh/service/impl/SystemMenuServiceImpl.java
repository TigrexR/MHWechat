package com.tigrex.mh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemMenuBO;
import com.tigrex.mh.entity.po.SystemMenu;
import com.tigrex.mh.entity.query.SystemMenuQuery;
import com.tigrex.mh.mapper.SystemMenuMapper;
import com.tigrex.mh.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linus
 */
@Service(value = "systemRoleService")
public class SystemMenuServiceImpl implements ISystemMenuService {

    @Autowired
    private SystemMenuMapper mapper;
    
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
}
