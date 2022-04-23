package com.tigrex.mh.controller;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemUserBO;
import com.tigrex.mh.entity.query.SystemUserQuery;
import com.tigrex.mh.entity.vo.SystemUserVO;
import com.tigrex.mh.service.ISystemUserService;

import com.tigrex.mh.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linus
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private ISystemUserService userService;
    @Autowired
    private RedisTemplate<String, SystemUserBO> userRedisTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello() {
        return "hello world!";
    }

    @RequestMapping(value = "/helloUser", method = RequestMethod.POST)
    public String helloUser() {
        System.out.println("hello from controller");
        return "hello world!";
    }

    @RequestMapping(value = "/getUserFromRedis", method = RequestMethod.POST)
    public SystemUserVO getUserFromRedis(@RequestBody() SystemUserQuery userQuery) {
        return JacksonUtils.getJackson().convertValue(userRedisTemplate.opsForValue().get("users::" + userQuery.getCode()),
                SystemUserVO.class);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody() SystemUserQuery userQuery) {
        return JwtUtils.createToken("geo", "swc", userService.getUser(userQuery), 3600000L);
    }
}
