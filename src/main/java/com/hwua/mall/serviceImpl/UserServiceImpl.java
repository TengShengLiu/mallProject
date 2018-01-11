package com.hwua.mall.serviceImpl;

import com.hwua.mall.dao.UserMapper;
import com.hwua.mall.po.User;
import com.hwua.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.queryAllUser();
    }
}
