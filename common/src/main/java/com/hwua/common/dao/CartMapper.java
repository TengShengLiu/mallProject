package com.hwua.common.dao;

import com.hwua.common.po.Cart;

import java.util.List;
import java.util.Map;

public interface CartMapper {
    public int addToCart(Map<String,Integer> params);

    public List<Cart> queryUnchecked(Map<String,Integer> params);

    public List<Cart> queryChecked(int mid);

    public Integer queryCount(Map<String,Integer> params);

    public Integer updateCount(Map<String,Integer> params);

    public int delProductInCart(Map<String,Integer> params);

    public int updateCartType(Map<String,Integer> params);

    public List<Integer> queryCartId(Map<String,Object> params);

    public List<Map<String,Integer>> queryCartPidCount(Map<String,Object> params);

    public int updateStatus(List<Integer> params);

    public List<Map<String,Object>> queryStatus0(int mid);

}
