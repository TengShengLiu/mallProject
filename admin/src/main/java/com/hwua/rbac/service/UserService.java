package com.hwua.rbac.service;

import com.hwua.rbac.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getAllUser();

    public User Login(String username,String password);
}
