package com.tigrex.rathalos.controller;

import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;
import com.tigrex.rathalos.service.ITemplateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linus
 */
@RestController
@RequestMapping(value = "/templateMessage")
public class TemplateMessageController {

    @Autowired
    private ITemplateMessageService service;

    @RequestMapping(value = "/sendTemplateMessage", method = RequestMethod.POST)
    public Integer sendTemplateMessage(@RequestBody()TemplateMessageRequest request) {
        return service.sendTemplateMessage(request);
    }
}
