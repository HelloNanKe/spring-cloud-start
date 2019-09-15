package com.zt.api;

import com.zt.domain.UserDomain;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: zt
 * @Date: 2019/9/15 2:43 下午
 */
@FeignClient(name = "zuul" ,path = "/order/user")
public interface ZuulService {

    @RequestMapping("/query/{userId}")
    List<UserDomain> queryUserListById(@PathVariable("userId") Integer userId);

}
