package com.hwua.common.dao;

import com.hwua.common.po.Orders;

import java.util.List;
import java.util.Map;

public interface OrdersMapper {
    public int addNewOrder(int mid);

    public Integer QueryMaxId(int mid);

    public List<Orders> queryAll(int mid);

    public List<Map<String,Object>> queryUnsend(int mid);

    public List<Map<String,Object>> queryUnReceive(int mid);
}
