package com.tigrex.rathalos.service;

import com.tigrex.rathalos.entity.wechat.AccessToken;
import com.tigrex.rathalos.entity.wechat.request.AccessTokenRequest;

/**
 * @author linus
 */
public interface IAccessTokenService {

    /**
     * get access token
     * @param appid appid
     * @return token
     */
    AccessToken getAccessToken(String appid);
}
