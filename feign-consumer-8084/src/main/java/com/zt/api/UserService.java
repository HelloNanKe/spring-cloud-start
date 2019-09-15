package com.zt.api;

import com.zt.domain.UserDomain;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: zt
 * @Date: 2019/9/14 5:34 下午
 */
@FeignClient(name = "PROVIDER", path = "/user")
public interface UserService {

    @RequestMapping("/query/{userId}")
    List<UserDomain> queryUserListById(@PathVariable("userId") Integer userId);

    @RequestMapping("/query/{user}")
    UserDomain queryUser(@PathVariable("user") UserDomain user);

}
