package com.tigrex.mh.controller;

import com.tigrex.core.utils.JacksonUtils;
import com.tigrex.mh.entity.bo.SystemUserBO;
import com.tigrex.mh.entity.query.SystemUserQuery;
import com.tigrex.mh.entity.vo.SystemUserVO;
import com.tigrex.mh.service.ISystemUserService;

import com.tigrex.core.utils.JwtUtils;
import com.tigrex.rathalos.client.TemplateMessageClient;
import com.tigrex.rathalos.entity.wechat.request.TemplateMessageRequest;
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
    @Autowired
    private TemplateMessageClient templateMessageClient;

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
        return JwtUtils.createToken("geo", "swc", userService.get(userQuery), 3600000L);
    }

    @RequestMapping(value = "/sendTemplateMessage", method = RequestMethod.POST)
    public Integer sendTemplateMessage(@RequestBody() TemplateMessageRequest request) {
        return templateMessageClient.sendTemplateMessage(request);
    }
}
