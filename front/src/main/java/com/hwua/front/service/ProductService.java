package com.hwua.front.service;

import com.hwua.common.po.Category;
import com.hwua.common.po.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getAll();

    public Product getProduct(int pid);

    public List<Map<String,Object>> getProductByMid(int mid);

    public List<Product> search(String info,int start,int pageSize);

    public List<Product> pageNum(String info);

    public List<Map<String,Object>> getType0(int mid);

    public int updateInventory(Map<String,Integer> params);

    public List<Category> initInfo();

    public List<Product> getMainInfo();
}
