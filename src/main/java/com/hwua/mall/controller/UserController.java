package com.hwua.mall.controller;

import com.hwua.mall.po.User;
import com.hwua.mall.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public void test1(){
        List<User> allUser = userService.getAllUser();
        for (User user:allUser) {
            System.out.println("user = " + user);
        }

    }

}
