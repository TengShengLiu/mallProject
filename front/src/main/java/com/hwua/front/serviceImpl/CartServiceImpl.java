package com.hwua.front.serviceImpl;

import com.hwua.common.dao.CartMapper;
import com.hwua.common.po.Cart;
import com.hwua.front.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    public int AddToCart(int mid, int pid, int count) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("pid",pid);
        map.put("mid",mid);
        map.put("count",count);
        return cartMapper.addToCart(map);
    }

    public List<Cart> getUnchecked(int mid, int pid) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mid",mid);
        map.put("pid",pid);
        return cartMapper.queryUnchecked(map);
    }

    public List<Cart> getChecked(int mid) {
        return cartMapper.queryChecked(mid);
    }

    public Integer getCount(int mid, int pid) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mid",mid);
        map.put("pid",pid);
        return cartMapper.queryCount(map);
    }


    public Integer updateCount(int mid, int pid,int count) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mid",mid);
        map.put("pid",pid);
        map.put("count",count);
        return cartMapper.updateCount(map);
    }

    public int delProductInCart(int mid, int pid) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mid",mid);
        map.put("pid",pid);
        return cartMapper.delProductInCart(map);
    }

    public int updateCartType(int mid, int pid, int type) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("mid",mid);
        map.put("pid",pid);
        map.put("type",type);
        return cartMapper.updateCartType(map);
    }

    public List<Integer> getCartId(int mid) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("mid",mid);
        return cartMapper.queryCartId(map);
    }

    public int updateStatus(List<Integer> params) {
        return cartMapper.updateStatus(params);
    }

    public List<Map<String, Integer>> getCartPidCount(int mid) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("mid",mid);
        return cartMapper.queryCartPidCount(map);
    }

    public List<Map<String, Object>> getStatus0(int mid) {
        return cartMapper.queryStatus0(mid);
    }


}
