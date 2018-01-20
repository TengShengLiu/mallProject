package com.hwua.common.dao;

import com.hwua.common.po.Member;

import java.util.Map;

public interface MemberMapper {

    public Member queryMember(Map<String, Object> params);

    public int insertMember(Map<String, Object> params);

    public int updateMember(Map<String, Object> params);

    public Member queryByName(String name);

    public int changPwd(Map<String, Object> params);

    public int updateAccount(Map<String,Object> params);
}
