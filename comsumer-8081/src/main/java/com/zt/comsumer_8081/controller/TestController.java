package com.zt.comsumer_8081.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: zt
 * @Date: 2019/9/14 9:35 上午
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/query/{userId}")
    public List query(@PathVariable("userId") Integer userId) {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://provider/user/query/"+userId, List.class);
        List body = responseEntity.getBody();
        return body;
    }


}
