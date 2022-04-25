package com.tigrex.rathalos.service;

import com.tigrex.rathalos.entity.bo.WechatOfficialTemplateBO;
import com.tigrex.rathalos.entity.query.WechatOfficialTemplateQuery;

import java.util.List;

/**
 * @author linus
 */
public interface IWechatOfficialTemplateService {

    /**
     * 查询模板
     * @param query query
     * @return list
     */
    List<WechatOfficialTemplateBO> listTemplates(WechatOfficialTemplateQuery query);
}
