package com.zt.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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


    /**
     * 手动实现服务降级
     * @param id
     * @return
     */
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

    /**
     * 通过注解实现服务降级
     * @param userId
     * @return
     */
    @RequestMapping(value = "/hystrixAnno/{userId}")
    @HystrixCommand(fallbackMethod = "queryUserFallBack")
    public Object hystrixAnnotation(@PathVariable("userId") Integer userId){
        return userService.queryUserListById(userId);
    }

    protected Object queryUserFallBack(Integer userId){
        UserDomain userDomain=new UserDomain();
        userDomain.setAge(-1);
        userDomain.setUserId(-1);
        userDomain.setUserName("服务降级");
        return userDomain;
    }

}
