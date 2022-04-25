package com.tigrex.rathalos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.rathalos.entity.bo.WechatOfficialTemplateBO;
import com.tigrex.rathalos.entity.po.WechatOfficialTemplate;
import com.tigrex.rathalos.entity.query.WechatOfficialTemplateQuery;
import com.tigrex.rathalos.mapper.WechatOfficialTemplateMapper;
import com.tigrex.rathalos.service.IWechatOfficialTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linus
 */
@Service(value = "wechatOfficialTemplateService")
public class WechatOfficialTemplateServiceImpl implements IWechatOfficialTemplateService {

    @Autowired
    private WechatOfficialTemplateMapper mapper;

    @Override
    public List<WechatOfficialTemplateBO> listTemplates(WechatOfficialTemplateQuery query) {
        return JacksonUtils.getJackson().convertValue(
                mapper.selectList(new LambdaQueryWrapper<WechatOfficialTemplate>()
                        .eq(WechatOfficialTemplate::getAppid, query.getAppid())
                        .eq(WechatOfficialTemplate::getTemplateId, query.getTemplateId())),
                new TypeReference<List<WechatOfficialTemplateBO>>(){});
    }
}
