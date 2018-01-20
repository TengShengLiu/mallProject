package com.hwua.front.serviceImpl;

import com.hwua.common.dao.ProductQueryMapper;
import com.hwua.common.po.Product;
import com.hwua.front.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductQueryMapper productQuery;

    public List<Product> getAll() {
        return productQuery.queryAll();
    }

    public Product getProduct(int pid) {
        return productQuery.queryByPid(pid);
    }

    public List<Map<String,Object>> getProductByMid(int mid) {
        return productQuery.queryByMid(mid);
    }

    public List<Product> search(String info) {
        return productQuery.fuzzySearch(info);
    }

    public List<Map<String, Object>> getType0(int mid) {
        return productQuery.queryType0(mid);
    }

    public int updateInventory(Map<String,Integer> params) {
        return productQuery.updateInventory(params);
    }
}
