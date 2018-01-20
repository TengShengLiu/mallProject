package com.hwua.common.dao;

import java.util.Map;

public interface OrdersMapper {
    public int addNewOrder(int mid);

    public Integer QueryMaxId(int mid);
}
