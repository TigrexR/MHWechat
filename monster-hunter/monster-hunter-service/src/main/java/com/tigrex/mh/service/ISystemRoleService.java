package com.tigrex.mh.service;

import com.tigrex.mh.entity.bo.SystemRoleBO;
import com.tigrex.mh.entity.query.SystemRoleQuery;

import java.util.List;

/**
 * @author linus
 */
public interface ISystemRoleService {

    /**
     * list
     * @param query query
     * @return list
     */
    List<SystemRoleBO> list(SystemRoleQuery query);

    /**
     * select roles by user
     * @param query query
     * @return list
     */
    List<SystemRoleBO> listRolesByUser(SystemRoleQuery query);
}
