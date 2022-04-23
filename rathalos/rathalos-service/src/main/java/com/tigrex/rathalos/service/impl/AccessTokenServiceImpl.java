package com.tigrex.rathalos.service.impl;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.rathalos.entity.wechat.AccessToken;
import com.tigrex.rathalos.service.IAccessTokenService;
import com.tigrex.rathalos.utils.HttpUtils;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author linus
 */
@Service(value = "accessTokenService")
public class AccessTokenServiceImpl implements IAccessTokenService {

    private String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID";

    @SneakyThrows
    @Override
    @Cacheable(value = "accessToken", key = "#appid", cacheManager = "accessTokenRedisCacheManager")
    public AccessToken getAccessToken(String appid) {
        //存入日志表
        String result = HttpUtils.httpURLConnection(URL.replace("APPID", appid), HttpUtils.GET, null);
        //更新日志表状态
        return JacksonUtils.getJackson().readValue(result, AccessToken.class);
    }
}
