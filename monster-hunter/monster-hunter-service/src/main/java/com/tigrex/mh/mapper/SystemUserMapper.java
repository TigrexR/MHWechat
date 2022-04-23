package com.tigrex.mh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tigrex.mh.entity.po.SystemUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * userMapper接口
 * @author linus
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {
}