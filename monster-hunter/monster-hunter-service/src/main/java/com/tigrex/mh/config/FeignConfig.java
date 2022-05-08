package com.tigrex.mh.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author linus
 */
@Configuration
@EnableFeignClients(basePackages = {"com.tigrex.rathalos.client"})
public class FeignConfig {
}
