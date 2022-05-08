package com.tigrex.mh.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemResourceBO;
import com.tigrex.mh.mapper.SystemResourceMapper;
import com.tigrex.mh.service.ISystemResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linus
 */
@Service(value = "systemResourceService")
public class SystemResourceServiceImpl implements ISystemResourceService {

    @Autowired
    private SystemResourceMapper mapper;

    @Override
    public List<SystemResourceBO> listResourcesByCode(List<String> resourceCodes) {
        return JacksonUtils.getJackson().convertValue(mapper.selectBatchIds(resourceCodes),
                new TypeReference<List<SystemResourceBO>>() {});
    }
}
