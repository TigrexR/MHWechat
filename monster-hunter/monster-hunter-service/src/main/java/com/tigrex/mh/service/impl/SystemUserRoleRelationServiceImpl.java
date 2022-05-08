package com.tigrex.mh.service.impl;

import com.tigrex.mh.mapper.SystemUserRoleRelationMapper;
import com.tigrex.mh.service.ISystemUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "systemUserRoleRelationService")
public class SystemUserRoleRelationServiceImpl implements ISystemUserRoleRelationService {

    @Autowired
    private SystemUserRoleRelationMapper mapper;
}
