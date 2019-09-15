package com.zt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: zt
 * @Date: 2019/9/14 4:38 下午
 */
@RestController
@RequestMapping()
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/query/user/{id}")
    public Object queryUser(@PathVariable("id") Integer id) {
        return restTemplate.getForEntity("http://PROVIDER/user/query/" + id, List.class);
    }

}
