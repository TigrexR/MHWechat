package com.tigrex.rathalos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tigrex.rathalos.entity.wechat.log.AccessTokenLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author linus
 */
@Mapper
public interface AccessTokenLogMapper extends BaseMapper<AccessTokenLog> {
}
