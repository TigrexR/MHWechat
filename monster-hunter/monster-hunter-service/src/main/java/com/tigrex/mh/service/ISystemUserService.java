package com.tigrex.mh.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tigrex.mh.entity.bo.SystemUserBO;
import com.tigrex.mh.entity.query.SystemUserQuery;

import java.util.List;

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

    /**
     * user list
     * @param query query
     * @return list
     */
    List<SystemUserBO> listUser(SystemUserQuery query);

    /**
     * user page
     * @param query
     * @return
     */
    Page<SystemUserBO> pageUser(SystemUserQuery query);
}