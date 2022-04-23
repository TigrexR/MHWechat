package com.tigrex.mh.service.impl;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemUserBO;
import com.tigrex.mh.entity.query.SystemUserQuery;
import com.tigrex.mh.mapper.SystemUserMapper;
import com.tigrex.mh.service.ISystemUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "systemUserService")
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private SystemUserMapper mapper;
    @Autowired
    @Qualifier(value = "monsterHunterExecutor")
    private AsyncTaskExecutor executor;

    @Override
    @Cacheable(value = "users", key = "#userQuery.code", cacheManager = "systemUserRedisCacheManager")
    public SystemUserBO getUser(SystemUserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(mapper.selectById(userQuery.getCode()), SystemUserBO.class);
    }
}
