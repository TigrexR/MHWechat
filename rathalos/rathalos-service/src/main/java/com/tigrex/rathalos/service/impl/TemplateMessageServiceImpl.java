package com.tigrex.rathalos.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.rathalos.entity.bo.WechatOfficialAccountBO;
import com.tigrex.rathalos.entity.query.WechatOfficialAccountQuery;
import com.tigrex.rathalos.entity.wechat.constant.Code;
import com.tigrex.rathalos.entity.wechat.log.TemplateMessageLog;
import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;
import com.tigrex.rathalos.mapper.TemplateMessageLogMapper;
import com.tigrex.rathalos.service.IAccessTokenService;
import com.tigrex.rathalos.service.ITemplateMessageService;
import com.tigrex.rathalos.service.IWechatOfficialAccountService;
import com.tigrex.rathalos.utils.HttpUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


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
    private IWechatOfficialAccountService wechatOfficialAccountService;

    @SneakyThrows
    @Override
    public Integer sendTemplateMessage(TemplateMessageRequest request) {
        WechatOfficialAccountBO account = wechatOfficialAccountService.get(new WechatOfficialAccountQuery().setAppid(request.getAppid()));
        if (account != null) {
            String result = HttpUtils.httpURLConnection(
                    URL.replace("ACCESS_TOKEN", accessTokenService.getAccessToken(account.getAppid(), account.getSecret())
                            .getAccessToken()), HttpUtils.POST, JacksonUtils.getJackson().writeValueAsString(request));
            String flag = JacksonUtils.getJackson().readValue(result, new TypeReference<Map<String, String>>() {})
                    .getOrDefault(Code.CODE_KEY, "1");
            mapper.insert(new TemplateMessageLog(null, request.getAppid(), request.getTemplateId(),
                    JacksonUtils.getJackson().writeValueAsString(request), result, Integer.parseInt(flag)));
            return Integer.parseInt(flag);
        } else {
            return 2;
        }
    }
}
