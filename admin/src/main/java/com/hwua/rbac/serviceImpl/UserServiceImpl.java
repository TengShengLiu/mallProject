package com.hwua.rbac.serviceImpl;

import com.hwua.common.dao.UserMapper;
import com.hwua.common.po.User;
import com.hwua.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User Login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uname",username);
        map.put("password",password);
        return userMapper.queryUser(map);
    }
}
