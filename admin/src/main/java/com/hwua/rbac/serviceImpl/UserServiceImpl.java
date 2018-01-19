package com.hwua.rbac.serviceImpl;

import com.hwua.rbac.dao.UserDao;
import com.hwua.rbac.po.User;
import com.hwua.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @RequestMapping
    public List<User> getAllUser() {
        return userDao.queryAllUser();
    }

    public User Login(String username, String password) {

        return null;
    }
}
