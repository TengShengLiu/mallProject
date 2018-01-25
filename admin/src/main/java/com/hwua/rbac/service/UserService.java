package com.hwua.rbac.service;


import com.hwua.common.po.User;


public interface UserService {
    public User Login(String username, String password);
}
