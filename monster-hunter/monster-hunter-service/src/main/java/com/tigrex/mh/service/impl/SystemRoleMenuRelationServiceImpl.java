package com.tigrex.mh.service.impl;

import com.tigrex.mh.mapper.SystemRoleMenuRelationMapper;
import com.tigrex.mh.service.ISystemRoleMenuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "systemRoleMenuRelationService")
public class SystemRoleMenuRelationServiceImpl implements ISystemRoleMenuRelationService {

    @Autowired
    private SystemRoleMenuRelationMapper mapper;
}
