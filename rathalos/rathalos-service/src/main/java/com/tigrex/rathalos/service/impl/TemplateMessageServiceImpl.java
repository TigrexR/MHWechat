package com.tigrex.rathalos.service.impl;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.rathalos.entity.bo.WechatOfficialTemplateBO;
import com.tigrex.rathalos.entity.query.WechatOfficialTemplateQuery;
import com.tigrex.rathalos.entity.wechat.log.TemplateMessageLog;
import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;
import com.tigrex.rathalos.mapper.TemplateMessageLogMapper;
import com.tigrex.rathalos.service.IAccessTokenService;
import com.tigrex.rathalos.service.ITemplateMessageService;
import com.tigrex.rathalos.service.IWechatOfficialTemplateService;
import com.tigrex.rathalos.utils.HttpUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author linus
 */
@Service(value = "templateMessageService")
public class TemplateMessageServiceImpl implements ITemplateMessageService {

    private static final String URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    @Autowired
    private TemplateMessageLogMapper mapper;
    @Autowired
    private IAccessTokenService accessTokenService;
    @Autowired
    private IWechatOfficialTemplateService wechatOfficialTemplateService;

    @SneakyThrows
    @Override
    public Integer sendTemplateMessage(TemplateMessageRequest request) {
        List<WechatOfficialTemplateBO> templates = wechatOfficialTemplateService.getTemplates(
                new WechatOfficialTemplateQuery().setTemplateId(request.getTemplateId()));
        if (CollectionUtils.isEmpty(templates)) {
            return 2;
        } else {
            String result = HttpUtils.httpURLConnection(
                    URL.replace("ACCESS_TOKEN", accessTokenService.getAccessToken(templates.get(0).getAppid())
                            .getAccessToken()), HttpUtils.POST, JacksonUtils.getJackson().writeValueAsString(request));
            mapper.insert(new TemplateMessageLog(null, request.getAppid(), request.getTemplateId(),
                    JacksonUtils.getJackson().writeValueAsString(request), result, 1));
            return 1;
        }
    }
}
