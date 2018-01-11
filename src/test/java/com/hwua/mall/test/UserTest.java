package com.hwua.mall.test;

import com.hwua.mall.po.User;
import com.hwua.mall.service.UserService;
import com.hwua.mall.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void getAllUser(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserService bean = ctx.getBean(UserService.class);
        List<User> allUser = bean.getAllUser();
        for (User user:allUser) {
            System.out.println("user = " + user);
        }


    }

    @Test
    public void testConnection(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    }


}
