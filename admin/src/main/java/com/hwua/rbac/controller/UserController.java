package com.hwua.rbac.controller;

import com.hwua.rbac.po.User;
import com.hwua.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public List<User> getAll(){
        List<User> allUser = userService.getAllUser();
        return allUser;
    }
}
