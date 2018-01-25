package com.hwua.common.dao;

import com.hwua.common.po.User;

import java.util.Map;

public interface UserMapper {
    public User queryUser(Map<String, Object> params);

}
