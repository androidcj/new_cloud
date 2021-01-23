package com.cj.project.consumer.controller;

import com.cj.project.consumer.entities.User;
import com.cj.project.consumer.service.ProductConsumeService;
//import com.pateo.entities.User;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 juncao
 * @创建时间 2019/12/18 13:17
 * @描述
 **/
@Api("redis验证接口")
@RestController
public class AuthController {
    @Autowired
    private ProductConsumeService productConsumeService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){
       return productConsumeService.login(user);
    }

    /**
     * getList熔断方法
     * @return
     */
    @RequestMapping(value = "/loginout/{userId}", method = RequestMethod.GET)
    public String loginout(@PathVariable("userId") String userId){
        return productConsumeService.loginout(userId);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody User user){
        return productConsumeService.register(user);
    }
}