package com.tigrex.mh.service;

import com.tigrex.mh.entity.bo.SystemUserBO;
import com.tigrex.mh.entity.query.SystemUserQuery;

/**
 * @author linus
 */
public interface ISystemUserService {

    /**
     * get user
     * @param userQuery
     * @return userBO
     */
    SystemUserBO getUser(SystemUserQuery userQuery);
}