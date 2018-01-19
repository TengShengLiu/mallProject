package com.hwua.front.serviceImpl;

import com.hwua.front.service.UserService;
import com.hwua.common.dao.UserMapper;
import com.hwua.common.po.User;
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
