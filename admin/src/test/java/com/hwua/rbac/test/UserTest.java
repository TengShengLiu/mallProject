package com.hwua.rbac.test;

import com.hwua.rbac.controller.UserController;
import com.hwua.rbac.po.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testGetAllUser(){
       ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserController bean = ctx.getBean(UserController.class);
        List<User> all = bean.getAll();
        System.out.println("all = " + all);
    }
}
