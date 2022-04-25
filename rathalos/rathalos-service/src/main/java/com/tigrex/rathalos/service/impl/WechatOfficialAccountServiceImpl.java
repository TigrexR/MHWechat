package com.tigrex.rathalos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.rathalos.entity.bo.WechatOfficialAccountBO;
import com.tigrex.rathalos.entity.po.WechatOfficialAccount;
import com.tigrex.rathalos.entity.query.WechatOfficialAccountQuery;
import com.tigrex.rathalos.mapper.WechatOfficialAccountMapper;
import com.tigrex.rathalos.service.IWechatOfficialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linus
 */
@Service(value = "wechatOfficialAccountService")
public class WechatOfficialAccountServiceImpl implements IWechatOfficialAccountService {

    @Autowired
    private WechatOfficialAccountMapper mapper;

    @Override
    public WechatOfficialAccountBO get(WechatOfficialAccountQuery query) {
        return JacksonUtils.getJackson().convertValue(
                mapper.selectOne(new LambdaQueryWrapper<WechatOfficialAccount>()
                        .eq(WechatOfficialAccount::getAppid, query.getAppid())),
                WechatOfficialAccountBO.class);
    }

    @Override
    public List<WechatOfficialAccountBO> list(WechatOfficialAccountQuery query) {
        return JacksonUtils.getJackson().convertValue(
                mapper.selectList(new LambdaQueryWrapper<WechatOfficialAccount>()
                        .eq(WechatOfficialAccount::getAppid, query.getAppid())),
                new TypeReference<List<WechatOfficialAccountBO>>() {});
    }
}
