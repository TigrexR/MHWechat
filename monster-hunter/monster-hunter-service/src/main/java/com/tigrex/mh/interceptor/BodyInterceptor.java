package com.tigrex.mh.interceptor;

import lombok.SneakyThrows;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linus
 */
public class BodyInterceptor extends HandlerInterceptorAdapter {

    private static final String login = "/user/login";
    private static final String logout = "/user/logout";
    private static final String USER_CODE = "code";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
    }
}
