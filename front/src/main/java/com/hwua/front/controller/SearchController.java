package com.hwua.front.controller;

import com.hwua.common.po.Product;
import com.hwua.front.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/search")
    public ModelAndView search(String info){
        List<Product> products = productService.search(info);
        System.out.println("products = " + products);
        ModelAndView view = new ModelAndView();
        view.addObject("products",products);
        view.setViewName("liebiao");
        return view;
    }
}
