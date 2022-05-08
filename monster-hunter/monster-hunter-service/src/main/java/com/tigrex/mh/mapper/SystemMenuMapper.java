package com.tigrex.mh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tigrex.mh.entity.bo.SystemMenuBO;
import com.tigrex.mh.entity.po.SystemMenu;
import com.tigrex.mh.entity.query.SystemMenuQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * userMapper接口
 * @author linus
 */
@Mapper
public interface SystemMenuMapper extends BaseMapper<SystemMenu> {

    /**
     * select menus by role codes
     * @param roleCodes role codes
     * @return list
     */
    List<SystemMenu> selectMenusByRoleCodes(@Param(value = "roleCode") List<String> roleCodes);
}