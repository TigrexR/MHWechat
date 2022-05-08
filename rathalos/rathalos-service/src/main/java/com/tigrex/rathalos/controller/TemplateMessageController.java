package com.tigrex.rathalos.controller;

import com.tigrex.rathalos.entity.wechat.constant.WechatUrl;
import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;
import com.tigrex.rathalos.service.ITemplateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author linus
 */
@RestController
@RequestMapping(value = "/templateMessage")
public class TemplateMessageController {

    @Autowired
    private ITemplateMessageService service;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders headers;
    @Autowired
    private WechatUrl wechatUrl;

    @RequestMapping(value = "/sendTemplateMessage", method = RequestMethod.POST)
    public Integer sendTemplateMessage(@RequestBody()TemplateMessageRequest request) {
        return service.sendTemplateMessage(request);
    }

    @RequestMapping(value = "/sendDS", method = RequestMethod.POST)
    public Integer sendDS(HttpServletRequest request) {
        headers.set(HttpHeaders.USER_AGENT, request.getHeader("USER-AGENT"));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<HashMap<String, String>> httpEntity = new HttpEntity<>(new HashMap<>(2), headers);
        String result = restTemplate.postForObject(wechatUrl.getDsUrl(), httpEntity, String.class);
        return 1;
    }
}
