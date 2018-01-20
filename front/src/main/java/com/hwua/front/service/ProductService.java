package com.hwua.front.service;

import com.hwua.common.po.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getAll();

    public Product getProduct(int pid);

    public List<Map<String,Object>> getProductByMid(int mid);

    public List<Product> search(String info);

    public List<Map<String,Object>> getType0(int mid);

    public int updateInventory(Map<String,Integer> params);
}
