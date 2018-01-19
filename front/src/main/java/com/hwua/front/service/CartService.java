package com.hwua.front.service;

import com.hwua.common.po.Cart;

import java.util.List;

public interface CartService {
    public int AddToCart(int mid,int pid,int count);

    public List<Cart> getUnchecked(int mid,int pid);

    public List<Cart> getChecked(int mid);

    public Integer getCount(int mid,int pid);

    public Integer updateCount(int mid,int pid,int count);

    public int delProductInCart(int mid,int pid);

    public int updateCartType(int mid,int pid,int type);
}




