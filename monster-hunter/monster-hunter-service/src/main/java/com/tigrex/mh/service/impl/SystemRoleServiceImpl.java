package com.tigrex.mh.service.impl;

import com.tigrex.mh.mapper.SystemRoleMapper;
import com.tigrex.mh.service.ISystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "systemRoleService")
public class SystemRoleServiceImpl implements ISystemRoleService {

    @Autowired
    private SystemRoleMapper mapper;
}
