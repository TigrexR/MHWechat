package com.tigrex.mh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemMenuBO;
import com.tigrex.mh.entity.bo.SystemRoleBO;
import com.tigrex.mh.entity.bo.SystemUserBO;
import com.tigrex.mh.entity.po.SystemUser;
import com.tigrex.mh.entity.query.SystemRoleQuery;
import com.tigrex.mh.entity.query.SystemUserQuery;
import com.tigrex.mh.mapper.SystemUserMapper;
import com.tigrex.mh.service.ISystemMenuService;
import com.tigrex.mh.service.ISystemRoleService;
import com.tigrex.mh.service.ISystemUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author linus
 */
@Service(value = "systemUserService")
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private SystemUserMapper mapper;
    @Autowired
    private ISystemRoleService systemRoleService;
    @Autowired
    private ISystemMenuService systemMenuService;

    @Override
    @Cacheable(value = "users", key = "#userQuery.code", cacheManager = "systemUserRedisCacheManager")
    public SystemUserBO get(SystemUserQuery userQuery) {
        SystemUserBO user = JacksonUtils.getJackson().convertValue(mapper.selectById(userQuery.getCode()), SystemUserBO.class);
        List<SystemRoleBO> roles = systemRoleService.listRolesByUser(new SystemRoleQuery().setUserCode(userQuery.getCode()));
        user.setRoles(roles);
        user.setMenus(systemMenuService.selectMenusByRoleCodes(
                roles.stream().map(SystemRoleBO::getCode).collect(Collectors.toList())));
        return user;
    }

    @Override
    public List<SystemUserBO> list(SystemUserQuery query) {
        List<SystemUser> users = mapper.selectList(new LambdaQueryWrapper<SystemUser>().func(q -> {
            if (query.getCode() != null) {
                q.eq(SystemUser::getCode, query.getCode());
            }
            if (query.getName() != null) {
                q.eq(SystemUser::getName, query.getName());
            }
            if (query.getIdCode() != null) {
                q.eq(SystemUser::getIdCode, query.getIdCode());
            }
            if (query.getPhone() != null) {
                q.eq(SystemUser::getPhone, query.getPhone());
            }
            if (query.getStatus() != null) {
                q.eq(SystemUser::getStatus, query.getStatus());
            }
        }));
        return JacksonUtils.getJackson().convertValue(users, new TypeReference<List<SystemUserBO>>() {});
    }

    @Override
    public Page<SystemUserBO> page(SystemUserQuery query) {
        Page<SystemUser> page = mapper.selectPage(new Page<>(), new LambdaQueryWrapper<SystemUser>().func(q -> {
            if (query.getCode() != null) {
                q.eq(SystemUser::getCode, query.getCode());
            }
            if (query.getName() != null) {
                q.eq(SystemUser::getName, query.getName());
            }
            if (query.getIdCode() != null) {
                q.eq(SystemUser::getIdCode, query.getIdCode());
            }
            if (query.getPhone() != null) {
                q.eq(SystemUser::getPhone, query.getPhone());
            }
            if (query.getStatus() != null) {
                q.eq(SystemUser::getStatus, query.getStatus());
            }
        }));
        return JacksonUtils.getJackson().convertValue(page, new TypeReference<Page<SystemUserBO>>() {});
    }
}
