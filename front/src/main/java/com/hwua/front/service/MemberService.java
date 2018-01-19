package com.hwua.front.service;

import com.hwua.common.po.Member;

public interface MemberService {

    /**
     * 登录
     * @param mname 用户名
     * @param password 密码
     * @return 用户信息
     */
    public Member Login(String mname, String password);


    /**
     *  注册
     * @param username
     * @param password
     * @param tel
     * @return
     */
    public int register(String username, String password, String tel);

    /**
     * 登陆完成的完善个人信息
     * @param gender
     * @param tel
     * @param email
     * @param mid
     * @return
     */
//    public int updateInfo(int gender,String tel,String email,String mid);

    /**
     * 查找指定会员
     * @param username
     * @return Member
     */
    public Member queryByName(String username);

    /**
     * 修改密码
     * @param password
     * @param mid
     * @return
     */
    public int changPwd(String password, int mid);
}
