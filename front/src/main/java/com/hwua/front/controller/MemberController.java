package com.hwua.front.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.front.service.MemberService;
import com.hwua.common.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(String username, String password, HttpSession session){
        System.out.println("username = [" + username + "], password = [" + password + "]");
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        Member member = memberService.Login(username, password);

        System.out.println("member = " + member);


        JSONObject jsonObject = new JSONObject();
        if (member == null){
            //用户名或密码错误
            jsonObject.put("flag",false);
            jsonObject.put("msg","用户名或密码错误");
        }else {
            //登录成功
            jsonObject.put("flag",true);
            jsonObject.put("msg","登陆成功");
            session.setAttribute("member",member);
        }
        return jsonObject.toJSONString();
    }


    @RequestMapping(value = "/checkUsername",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String checkUsername(String username){

        System.out.println("username = [" + username + "]");

        Member member = memberService.queryByName(username);

        JSONObject jsonObject = new JSONObject();
        if (member != null){
            jsonObject.put("flag",false);
            jsonObject.put("msg","该用已存在");
        }else {
            jsonObject.put("flag",true);
            jsonObject.put("msg","该用户名可用");
        }
        return jsonObject.toJSONString();
    }


    @RequestMapping(value = "/register",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String register(String username,String password,String repassword,String tel,HttpSession session){
        System.out.println("username = [" + username + "], password = [" + password + "], repassword = [" + repassword + "], tel = [" + tel + "]");
        Member member1 = memberService.queryByName(username);

        System.out.println("member1 = " + member1);

        JSONObject jsonObject = new JSONObject();
        if (member1 != null && !"".equals(member1)){
            //此用户存在
            jsonObject.put("flag",false);
            jsonObject.put("msg","此用户存在");
            return jsonObject.toJSONString();
        }else if (password.equals(repassword)){
            //用户不存在，密码一致，执行注册
            password = DigestUtils.md5DigestAsHex(repassword.getBytes());
            int i = memberService.register(username,password,tel);

            System.out.println("i = " + i);

            if (i==1){
                //注册成功
                Member member = memberService.Login(username, repassword);
                jsonObject.put("flag",true);
                session.setAttribute("member",member);
            }
            return jsonObject.toJSONString();
        }else {
            //密码不一致，请重新输入
            jsonObject.put("flag",false);
            jsonObject.put("msg","两次输入密码不一致，请重新输入");
            return jsonObject.toJSONString();
        }
    }


    //验证两次密码输入是否一致
    @RequestMapping(value = "/checkPwd1",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String checkPwd1(String password,String repassword){

        JSONObject jsonObject = new JSONObject();
        if (!password.equals(repassword)){
            //两次输入密码一致
            jsonObject.put("flag",false);
            jsonObject.put("msg","两次输入密码不一致");
        }else {
            //输入密码一致
            jsonObject.put("flag",true);
            jsonObject.put("msg","输入密码一致");
        }
        return jsonObject.toJSONString();
    }

    //验证原密码输入正确
    @RequestMapping(value = "/checkPwd2",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String checkPwd2(String pwd1,HttpSession session){
        pwd1 = DigestUtils.md5DigestAsHex(pwd1.getBytes());
        Member member = (Member) session.getAttribute("member");
        String password = member.getPassword();
        JSONObject jsonObject = new JSONObject();
        if (password.equals(pwd1)){
            jsonObject.put("flag",true);
            jsonObject.put("msg","原密码输入正确");
        }else {
            jsonObject.put("flag",false);
            jsonObject.put("msg","输入原密码错误");
        }
        return jsonObject.toJSONString();
    }



    @RequestMapping(value = "/changePwd",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String changPwd(String pwd1,String pwd2,String pwd3,HttpSession session){
        pwd1 = DigestUtils.md5DigestAsHex(pwd1.getBytes());
        pwd2 = DigestUtils.md5DigestAsHex(pwd2.getBytes());
        pwd3 = DigestUtils.md5DigestAsHex(pwd3.getBytes());
        Member member = (Member) session.getAttribute("member");
        int mid = member.getMid();
        String password = member.getPassword();
        JSONObject jsonObject = new JSONObject();
        if (!pwd1.equals(password)){
            //输入原密码不一致
            jsonObject.put("flag",false);
            jsonObject.put("msg","输入密码错误，请重新输入");
            return jsonObject.toJSONString();
        }else {
            //输入密码一致,比较新密码
            if (pwd2.equals(pwd3)){
                //两次输入密码一致,修改密码
                int i = memberService.changPwd(pwd3, mid);
                if (i==1){
                    jsonObject.put("flag",true);
                }else {
                    jsonObject.put("flag",false);
                    jsonObject.put("msg","修改密码失败，请重新输入");
                }
                return jsonObject.toJSONString();
            }else {
                //输入密码不一致
                jsonObject.put("flag",false);
                jsonObject.put("msg","两次输入密码不一致");
                return jsonObject.toJSONString();
            }
        }
    }


    @RequestMapping("/logout")
    public void exit(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/login");
    }



    /*
    @RequestMapping("/logout")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }*/




}
