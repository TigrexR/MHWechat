package com.tigrex.mh.service.impl;

import com.tigrex.mh.mapper.SystemMenuMapper;
import com.tigrex.mh.service.ISystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "systemRoleService")
public class SystemMenuServiceImpl implements ISystemMenuService {

    @Autowired
    private SystemMenuMapper mapper;
}
