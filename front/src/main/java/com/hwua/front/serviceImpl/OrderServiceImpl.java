package com.hwua.front.serviceImpl;

import com.hwua.common.dao.OrderDetailsMapper;
import com.hwua.common.dao.OrdersMapper;
import com.hwua.front.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
