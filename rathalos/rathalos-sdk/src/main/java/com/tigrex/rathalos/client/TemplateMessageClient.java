package com.tigrex.rathalos.client;

import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author linus
 */
@FeignClient(value = "rathalos", contextId = "templateMessage", path = "/templateMessage")
public interface TemplateMessageClient {

    /**
     * send template message
     * @param request request
     * @return int
     */
    @RequestMapping(value = "/sendTemplateMessage", method = RequestMethod.POST)
    Integer sendTemplateMessage(@RequestBody() TemplateMessageRequest request);
}
