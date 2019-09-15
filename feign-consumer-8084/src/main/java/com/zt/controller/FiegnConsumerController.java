package com.zt.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.zt.api.UserHystrixCommand;
import com.zt.api.UserService;
import com.zt.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zt
 * @Date: 2019/9/14 5:40 下午
 */
@RestController
@RequestMapping(value = "/fiegn")
public class FiegnConsumerController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/query/{userId}")
    public List<UserDomain> queryUser(@PathVariable("userId") Integer userId) {
        return userService.queryUserListById(userId);
    }

 /*   @RequestMapping(value = "/query/{user}")
    public UserDomain queryUserInfo(@PathVariable("user") UserDomain userDomain){
        return userService.queryUser(userDomain);
    }*/

    @RequestMapping(value = "/hystrix/{hystrix}")
    public Object hystrixTest(@PathVariable("hystrix") Integer id){
        HystrixCommandGroupKey hystrixCommandGroupKey=new HystrixCommandGroupKey() {
            @Override
            public String name() {
                return "user";
            }
        };
        UserHystrixCommand userHystrixCommand=new UserHystrixCommand(hystrixCommandGroupKey,id,userService);
        return userHystrixCommand.execute();
    }

}
