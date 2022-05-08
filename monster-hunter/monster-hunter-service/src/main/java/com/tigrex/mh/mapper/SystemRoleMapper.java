package com.tigrex.mh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tigrex.mh.entity.po.SystemRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * userMapper接口
 * @author linus
 */
@Mapper
public interface SystemRoleMapper extends BaseMapper<SystemRole> {

    /**
     * select roles by user code
     * @param code code
     * @return list
     */
    List<SystemRole> selectRolesByUserCode(@Param(value = "code") String code);
}