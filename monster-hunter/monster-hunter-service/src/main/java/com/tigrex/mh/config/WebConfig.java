package com.tigrex.mh.config;

import com.tigrex.mh.interceptor.BodyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author linus
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public BodyInterceptor bodyInterceptor(){
        return new BodyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bodyInterceptor()).addPathPatterns("/**");
    }
}
