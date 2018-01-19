package com.hwua.front.controller;

import com.hwua.common.po.User;
import com.hwua.front.service.UserService;
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
