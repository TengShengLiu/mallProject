package com.hwua.front.service;

import com.hwua.common.po.OrderDetails;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {
    public int addNewInfo(Map<String,Integer> params);

    public List<OrderDetails> getAll(int mid);
}
