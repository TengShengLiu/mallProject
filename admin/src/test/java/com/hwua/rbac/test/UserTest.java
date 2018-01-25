package com.hwua.rbac.test;

import com.hwua.common.dao.MemberMapper;
import com.hwua.common.dao.UserMapper;
import com.hwua.common.po.User;
import com.hwua.rbac.service.MemberService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
    @Test
    public void testGetAllUser(){
       ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        MemberMapper bean = ctx.getBean(MemberMapper.class);
        List<Map<String, Object>> maps = bean.queryAllMembers();
        System.out.println("maps = " + maps);
    }
}
