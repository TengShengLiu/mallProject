package com.hwua.front.serviceImpl;

import com.hwua.common.dao.MemberMapper;
import com.hwua.common.po.Member;
import com.hwua.front.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public Member Login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username",username);
        map.put("password",password);
        return memberMapper.queryMember(map);
    }

    public int register(String username, String password,String tel) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username",username);
        map.put("password",password);
        map.put("tel",tel);
        System.out.println("ServiceImpl-----------map = " + map);
        return memberMapper.insertMember(map);
    }

   /* public int updateInfo(int gender, String tel, String email,String mid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gender",gender);
        map.put("tel",tel);
        map.put("email",email);
        map.put("mid",mid);
        return memberMapper.updateMember(map);
    }*/

    public Member queryByName(String username) {
        return memberMapper.queryByName(username);
    }

    public int changPwd(String password,int mid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password",password);
        map.put("mid",mid);
        return memberMapper.changPwd(map);
    }

    public int updateAccount(int mid, double expense) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mid",mid);
        map.put("expense",expense);
        return memberMapper.updateAccount(map);
    }
}
