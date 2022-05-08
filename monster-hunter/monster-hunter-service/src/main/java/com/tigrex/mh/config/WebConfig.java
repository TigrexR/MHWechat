package com.tigrex.mh.config;

import com.tigrex.mh.interceptor.BodyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author linus
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean(value = "monsterHunterRestTemplate")
    public RestTemplate monsterHunterRestTemplate() {
        return new RestTemplate();
    }

    @Bean(value = "monsterHunterHttpHeaders")
    public HttpHeaders monsterHunterHttpHeaders() {
        return new HttpHeaders();
    }

    @Bean
    public BodyInterceptor bodyInterceptor(){
        return new BodyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bodyInterceptor()).addPathPatterns("/**");
    }
}
