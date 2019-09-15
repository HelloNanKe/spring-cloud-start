package com.zt.controller;

import com.zt.api.ZuulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zt
 * @Date: 2019/9/15 2:45 下午
 */
@RestController
@RequestMapping(value = "/zuul")
public class ZuulTestController {

    @Autowired
    private ZuulService zuulService;

    @RequestMapping(value = "/user/{userId}")
    public Object getUser(@PathVariable("userId") Integer userId) {
        return zuulService.queryUserListById(userId);
    }

}
