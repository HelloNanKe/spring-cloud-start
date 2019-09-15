package com.zt.provider8082.controller;

import com.zt.provider8082.domain.UserDomain;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zt
 * @Date: 2019/9/14 9:39 上午
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/query/{userId}")
    public List<UserDomain> queryUserById(@PathVariable("userId") Integer id) {

        if(id==6){
            throw new RuntimeException("测试服务降级");
        }

        List<UserDomain> list = new ArrayList<>();
        UserDomain userDomain = new UserDomain();
        userDomain.setUserId(id);
        userDomain.setUserName("测试");
        userDomain.setAge(18);
        list.add(userDomain);

        return list;
    }


 /*   @RequestMapping(value = "/query/{user}")
    public UserDomain queryUser(@PathVariable("user") UserDomain userDomain){

        return userDomain;
    }*/

}
