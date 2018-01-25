package com.hwua.common.dao;

import com.hwua.common.po.OrderDetails;

import java.util.List;
import java.util.Map;

public interface OrderDetailsMapper {
    public int addNewInfo(Map<String,Integer> params);

    public List<OrderDetails> queryAll(int mid);
}
