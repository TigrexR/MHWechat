package com.tigrex.rathalos.service;

import com.tigrex.rathalos.entity.bo.WechatOfficialAccountBO;
import com.tigrex.rathalos.entity.query.WechatOfficialAccountQuery;

import java.util.List;

/**
 * @author linus
 */
public interface IWechatOfficialAccountService {

    /**
     * get account
     * @param query query
     * @return account
     */
    WechatOfficialAccountBO get(WechatOfficialAccountQuery query);

    /**
     * list account
     * @param query query
     * @return list
     */
    List<WechatOfficialAccountBO> list(WechatOfficialAccountQuery query);
}
