package com.tigrex.mh.service;

import com.tigrex.mh.entity.bo.SystemResourceBO;

import java.util.List;

/**
 * @author linus
 */
public interface ISystemResourceService {

    /**
     * resources list
     * @param resourceCodes resourceCodes
     * @return list
     */
    List<SystemResourceBO> listResourcesByCode(List<String> resourceCodes);
}
