package com.tigrex.rathalos.service.impl;

import com.tigrex.rathalos.entity.bo.WechatOfficialTemplateBO;
import com.tigrex.rathalos.entity.query.WechatOfficialTemplateQuery;
import com.tigrex.rathalos.mapper.WechatOfficialTemplateMapper;
import com.tigrex.rathalos.service.IWechatOfficialTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linus
 */
@Service(value = "wechatOfficialAccountService")
public class WechatOfficialTemplateServiceImpl implements IWechatOfficialTemplateService {

    @Autowired
    private WechatOfficialTemplateMapper mapper;

    @Override
    public List<WechatOfficialTemplateBO> getTemplates(WechatOfficialTemplateQuery query) {
        return null;
    }
}
