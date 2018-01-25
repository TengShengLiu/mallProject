package com.hwua.front.service;

import com.hwua.common.po.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {
    public int AddToCart(int mid,int pid,int count);

    public List<Cart> getUnchecked(int mid,int pid);

    public List<Cart> getChecked(int mid);

    public Integer getCount(int mid,int pid);

    public Integer updateCount(int mid,int pid,int count);

    public int delProductInCart(int mid,int pid);

    public int updateCartType(int mid,int pid,int type);

    public List<Integer> getCartId(int mid);

    public int updateStatus(List<Integer> params);

    public List<Map<String,Integer>> getCartPidCount(int mid);

    public List<Map<String,Object>> getStatus0(int mid);

}




