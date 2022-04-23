package com.tigrex.rathalos.service;

import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;

/**
 * @author linus
 */
public interface ITemplateMessageService {

    /**
     * 推送模板消息
     * @param request request
     * @return int
     */
    Integer sendTemplateMessage(TemplateMessageRequest request);
}
