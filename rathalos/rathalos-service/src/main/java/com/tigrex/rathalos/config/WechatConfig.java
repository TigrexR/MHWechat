package com.tigrex.rathalos.config;

import com.tigrex.rathalos.entity.wechat.constant.WechatUrl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author linus
 */
@Configuration
public class WechatConfig {

    @Bean(value = "wechatUrl")
    @ConfigurationProperties(prefix = "rathalos.wechat")
    public WechatUrl wechatUrl(){
        return new WechatUrl();
    }
}
