package com.hwua.front.controller;

import com.hwua.common.po.Product;
import com.hwua.front.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/search")
    public ModelAndView search(String info){
        info = info.trim();
        int pageSize = 5;
        List<Product> products = productService.search(info,0,pageSize);
        List<Product> products1 = productService.pageNum(info);

        int pageNum = (products1.size()/pageSize)+1;

        ModelAndView view = new ModelAndView();
        view.addObject("products",products);
        view.setViewName("liebiao");
        view.addObject("info",info);
        view.addObject("pageNum",pageNum);
        return view;
    }


    @RequestMapping(value = "/changePage")
    public ModelAndView changePageNum(String info,int pageNum){
        System.out.println("info = [" + info + "], pageNum = [" + pageNum + "]");

        int pageSize = 5;
        info = info.trim();
        int start = (pageNum - 1) * pageSize;


        List<Product> products = productService.search(info, start, pageSize);
        List<Product> products1 = productService.pageNum(info);
        pageNum = (products1.size()/pageSize)+1;


        System.out.println("pageNum = " + pageNum);
        System.out.println("products = " + products);


        ModelAndView view = new ModelAndView();
        view.addObject("products",products);
        view.setViewName("liebiao");
        view.addObject("info",info);
        view.addObject("pageNum",pageNum);
        return view;
    }


}
