package com.tigrex.rathalos.service.impl;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.rathalos.entity.bo.WechatOfficialAccountBO;
import com.tigrex.rathalos.entity.query.WechatOfficialAccountQuery;
import com.tigrex.rathalos.entity.wechat.BaseWechatResponse;
import com.tigrex.rathalos.entity.wechat.constant.WechatUrl;
import com.tigrex.rathalos.entity.wechat.log.TemplateMessageLog;
import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;
import com.tigrex.rathalos.mapper.TemplateMessageLogMapper;
import com.tigrex.rathalos.service.IAccessTokenService;
import com.tigrex.rathalos.service.ITemplateMessageService;
import com.tigrex.rathalos.service.IWechatOfficialAccountService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


/**
 * @author linus
 */
@Service(value = "templateMessageService")
public class TemplateMessageServiceImpl implements ITemplateMessageService {

    @Autowired
    private TemplateMessageLogMapper mapper;
    @Autowired
    private IAccessTokenService accessTokenService;
    @Autowired
    private IWechatOfficialAccountService wechatOfficialAccountService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders headers;
    @Autowired
    private WechatUrl wechatUrl;

    @SneakyThrows
    @Override
    public Integer sendTemplateMessage(TemplateMessageRequest request) {
        WechatOfficialAccountBO account = wechatOfficialAccountService.get(new WechatOfficialAccountQuery().setAppid(request.getAppid()));
        if (account != null) {
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<TemplateMessageRequest> httpEntity = new HttpEntity<>(request, headers);
            ResponseEntity<BaseWechatResponse> response = restTemplate.postForEntity(
                    wechatUrl.getHost() + wechatUrl.getMessageTemplateSend().replace("ACCESS_TOKEN",
                            accessTokenService.getAccessToken(account.getAppid(), account.getSecret()).getAccessToken()),
                    httpEntity, BaseWechatResponse.class);
            mapper.insert(new TemplateMessageLog(null, request.getAppid(), request.getTemplateId(),
                    JacksonUtils.getJackson().writeValueAsString(request), JacksonUtils.getJackson().writeValueAsString(response.getBody()),
                    Objects.requireNonNull(response.getBody()).getErrCode()));
            return response.getBody().getErrCode();
        } else {
            return 2;
        }
    }
}
