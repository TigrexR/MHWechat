package com.tigrex.rathalos.service.impl;

import com.tigrex.rathalos.mapper.WechatOfficialAccountMapper;
import com.tigrex.rathalos.service.IWechatOfficialAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "wechatOfficialAccountService")
public class WechatOfficialAccountServiceImpl implements IWechatOfficialAccountService {

    @Autowired
    private WechatOfficialAccountMapper mapper;
}
