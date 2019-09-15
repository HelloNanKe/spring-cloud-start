package com.zt.api;

import com.zt.domain.UserDomain;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * userService的降级方法
 *
 * @Author: zt
 * @Date: 2019/9/15 11:45 上午
 */
@Component
public class UserServiceFallBack implements UserService {

    @Override
    public List<UserDomain> queryUserListById(Integer userId) {
        return null;
    }

    @Override
    public UserDomain queryUser(UserDomain user) {
        return null;
    }

}
