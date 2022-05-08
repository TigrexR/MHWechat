package com.tigrex.rathalos.service.impl;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.rathalos.entity.wechat.AccessToken;
import com.tigrex.rathalos.entity.wechat.constant.WechatUrl;
import com.tigrex.rathalos.entity.wechat.log.AccessTokenLog;
import com.tigrex.rathalos.mapper.AccessTokenLogMapper;
import com.tigrex.rathalos.service.IAccessTokenService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author linus
 */
@Service(value = "accessTokenService")
public class AccessTokenServiceImpl implements IAccessTokenService {

    @Autowired
    private AccessTokenLogMapper mapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders headers;
    @Autowired
    private WechatUrl wechatUrl;

    @SneakyThrows
    @Override
    @Cacheable(value = "accessToken", key = "#appid+#secret", cacheManager = "accessTokenRedisCacheManager")
    public AccessToken getAccessToken(String appid, String secret) {
        ResponseEntity<AccessToken> response = restTemplate.getForEntity(wechatUrl.getHost()
                + wechatUrl.getToken().replace("APPID", appid).replace("SECRET", secret), AccessToken.class);
        //更新日志表状态
        mapper.insert(new AccessTokenLog(null, "client_credential", appid, secret,
                JacksonUtils.getJackson().writeValueAsString(response.getBody()), 1));
        return response.getBody();
    }
}
