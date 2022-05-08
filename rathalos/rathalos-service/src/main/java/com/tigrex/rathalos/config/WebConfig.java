package com.tigrex.rathalos.config;

import com.tigrex.rathalos.interceptor.BodyInterceptor;
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

    @Bean(value = "rathalosRestTemplate")
    public RestTemplate rathalosRestTemplate() {
        return new RestTemplate();
    }

    @Bean(value = "rathalosHttpHeaders")
    public HttpHeaders rathalosHttpHeaders() {
        return new HttpHeaders();
    }

    @Bean(value = "bodyInterceptor")
    public BodyInterceptor bodyInterceptor(){
        return new BodyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bodyInterceptor()).addPathPatterns("/**");
    }
}
