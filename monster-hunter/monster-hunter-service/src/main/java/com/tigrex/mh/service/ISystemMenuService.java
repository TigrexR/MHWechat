package com.tigrex.mh.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tigrex.mh.entity.bo.SystemMenuBO;
import com.tigrex.mh.entity.query.SystemMenuQuery;

import java.util.List;

/**
 * @author linus
 */
public interface ISystemMenuService {

    /**
     * save or update
     * @param data data
     * @return int
     */
    Integer saveOrUpdate(SystemMenuBO data);

    /**
     * remove
     * @param query query
     * @return int
     */
    Integer remove(SystemMenuQuery query);

    /**
     * get
     * @param query query
     * @return user
     */
    SystemMenuBO get(SystemMenuQuery query);

    /**
     * list
     * @param query q
     * @return list
     */
    List<SystemMenuBO> list(SystemMenuQuery query);

    /**
     * page
     * @param query q
     * @return page
     */
    Page<SystemMenuBO> page(SystemMenuQuery query);
}
