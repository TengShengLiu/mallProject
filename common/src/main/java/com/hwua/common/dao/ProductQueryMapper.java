package com.hwua.common.dao;

import com.hwua.common.po.Category;
import com.hwua.common.po.Product;

import java.util.List;
import java.util.Map;

public interface ProductQueryMapper {
    public List<Product> queryAll();

    public Product queryByPid(int pid);

    public List<Map<String,Object>> queryByMid(int mid);

    public List<Product> fuzzySearch(Map<String,Object> params);
    public List<Product> pageNum(String info);

    public List<Map<String,Object>> queryType0(int mid);

    public int updateInventory(Map<String,Integer> params);

    public List<Category> initQueryAll();

    public List<Product> queryPhone();

    public List<Product> queryTV();

    public List<Product> queryMainInfo();

    public int addNewProduct(Map<String,Object> params);

    public List<Product> queryAllProducts();

    public int reSetProStatus1(int pid);

    public int reSetProStatus0(int pid);

    public int reSetProStatus2(int pid);

    public int updateProduct(Product product);
}
