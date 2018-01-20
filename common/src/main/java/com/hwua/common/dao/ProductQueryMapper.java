package com.hwua.common.dao;

import com.hwua.common.po.Product;

import java.util.List;
import java.util.Map;

public interface ProductQueryMapper {
    public List<Product> queryAll();

    public Product queryByPid(int pid);

    public List<Map<String,Object>> queryByMid(int mid);

    public List<Product> fuzzySearch(String info);

    public List<Map<String,Object>> queryType0(int mid);

    public int updateInventory(Map<String,Integer> params);
}
