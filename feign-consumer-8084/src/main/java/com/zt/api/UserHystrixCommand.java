package com.zt.api;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.zt.domain.UserDomain;

/**
 * @Author: zt
 * @Date: 2019/9/15 9:24 上午
 */
public class UserHystrixCommand extends HystrixCommand<Object> {

    private Integer id;

    private UserService userService;

    @Override
    protected Object run() throws Exception {
        System.err.println("执行正常方法");
        return userService.queryUserListById(id);
    }

    @Override
    protected Object getFallback() {
        System.err.println("触发服务降级");
        UserDomain userDomain=new UserDomain();
        userDomain.setAge(-1);
        userDomain.setUserId(-1);
        userDomain.setUserName("服务降级");
        return userDomain;
    }



    public UserHystrixCommand(HystrixCommandGroupKey group, Integer id, UserService userService) {
        super(group);
        this.id = id;
        this.userService = userService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
