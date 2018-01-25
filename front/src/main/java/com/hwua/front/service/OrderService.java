package com.hwua.front.service;

import com.hwua.common.po.Orders;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public int addNewOrder(int mid);

    public Integer getMaxId(int mid);

    public List<Orders> getAll(int mid);

    public List<Map<String,Object>> getUnsend(int mid);

    public List<Map<String,Object>> getUnReceive(int mid);
}
