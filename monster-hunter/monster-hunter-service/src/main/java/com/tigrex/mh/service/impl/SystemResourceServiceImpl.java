package com.tigrex.mh.service.impl;

import com.tigrex.mh.mapper.SystemResourceMapper;
import com.tigrex.mh.service.ISystemResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "systemRoleService")
public class SystemResourceServiceImpl implements ISystemResourceService {

    @Autowired
    private SystemResourceMapper mapper;
}
