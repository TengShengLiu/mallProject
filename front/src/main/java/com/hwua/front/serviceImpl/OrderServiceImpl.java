package com.hwua.front.serviceImpl;

import com.hwua.common.dao.OrderDetailsMapper;
import com.hwua.common.dao.OrdersMapper;
import com.hwua.common.po.Orders;
import com.hwua.front.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;


    public int addNewOrder(int mid) {
        return ordersMapper.addNewOrder(mid);
    }

    public Integer getMaxId(int mid) {
        return ordersMapper.QueryMaxId(mid);
    }

    public List<Orders> getAll(int mid) {
        return ordersMapper.queryAll(mid);
    }

    public List<Map<String, Object>> getUnsend(int mid) {
        return ordersMapper.queryUnsend(mid);
    }

    public List<Map<String, Object>> getUnReceive(int mid) {
        return ordersMapper.queryUnReceive(mid);
    }

}
