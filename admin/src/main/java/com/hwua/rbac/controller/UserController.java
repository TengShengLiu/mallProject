package com.hwua.rbac.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.common.po.Address;
import com.hwua.common.po.Member;
import com.hwua.common.po.User;
import com.hwua.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(String username,String password ,HttpSession session){
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userService.Login(username, password);

        JSONObject jsonObject = new JSONObject();
        if(user == null){
            //用户名或密码错误
            jsonObject.put("flag",false);
            jsonObject.put("msg","用户名或密码错误");
        }else {
            //登录成功
            jsonObject.put("flag",true);
            jsonObject.put("msg","登陆成功");
            session.setAttribute("user",user);
        }
        return jsonObject.toJSONString();
    }


}
