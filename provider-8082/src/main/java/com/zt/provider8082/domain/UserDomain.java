package com.zt.provider8082.domain;

import org.omg.CORBA.INTERNAL;

import java.io.Serializable;

/**
 * @Author: zt
 * @Date: 2019/9/14 9:40 上午
 */
public class UserDomain implements Serializable {

    private Integer userId;

    private String userName;

    private int age;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
