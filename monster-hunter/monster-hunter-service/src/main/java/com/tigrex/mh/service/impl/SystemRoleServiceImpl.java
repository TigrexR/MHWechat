package com.tigrex.mh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemRoleBO;
import com.tigrex.mh.entity.po.SystemRole;
import com.tigrex.mh.entity.query.SystemRoleQuery;
import com.tigrex.mh.mapper.SystemRoleMapper;
import com.tigrex.mh.service.ISystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linus
 */
@Service(value = "systemRoleService")
public class SystemRoleServiceImpl implements ISystemRoleService {

    @Autowired
    private SystemRoleMapper mapper;

    @Override
    public List<SystemRoleBO> list(SystemRoleQuery query) {
        List<SystemRole> systemRoles = mapper.selectList(new LambdaQueryWrapper<SystemRole>().func(q -> {
            if (query.getCode() != null) {
                q.eq(SystemRole::getCode, query.getCode());
            }
        }));
        return JacksonUtils.getJackson().convertValue(systemRoles, new TypeReference<List<SystemRoleBO>>() {});
    }

    @Override
    public List<SystemRoleBO> listRolesByUser(SystemRoleQuery query) {
        return JacksonUtils.getJackson().convertValue(mapper.selectRolesByUserCode(query.getUserCode()),
                new TypeReference<List<SystemRoleBO>>() {});
    }
}
