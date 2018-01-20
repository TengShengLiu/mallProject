package com.hwua.front.serviceImpl;

import com.hwua.common.dao.OrderDetailsMapper;
import com.hwua.common.dao.OrdersMapper;
import com.hwua.front.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;


    public int addNewInfo(Map<String, Integer> params) {
        return orderDetailsMapper.addNewInfo(params);
    }
}
