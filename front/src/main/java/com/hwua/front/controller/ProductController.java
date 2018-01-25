package com.hwua.front.controller;

import com.hwua.common.po.Member;
import com.hwua.common.po.Product;
import com.hwua.front.service.CartService;
import com.hwua.front.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;


    @RequestMapping(value = "/getProductInfo")
    public ModelAndView toProInfo(int pid){
        System.out.println("pid = [" + pid + "]");
        ModelAndView view = new ModelAndView();
        Product product = productService.getProduct(pid);
        view.addObject("product", product);
        view.setViewName("xiangqing");
        return view;
    }

    //根据mid查询未结账购物车中的商品
    @RequestMapping(value = "/toCart", produces = "application/json;charset=utf-8")
    public ModelAndView toCart(HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        int mid = member.getMid();
        //获取所有购物车中的商品
        List<Map<String,Object>> products = productService.getProductByMid(mid);
        //获取所有准备购买的商品
        List<Map<String, Object>> type0 = productService.getType0(mid);
        int total=0;
        int i;
        for(i = 0;i<type0.size();i++){
            Map<String, Object> map = type0.get(i);
            Integer count = (Integer) map.get("count");
            System.out.println("count = " + count);
            Integer selprice = (Integer) map.get("SELPRICE");
            System.out.println("selprice = " + selprice);
            total += (count*selprice);
        }
        int size = type0.size();
        ModelAndView view = new ModelAndView();
        view.addObject("size",size);
        view.addObject("i",i);
        view.addObject("products",products);
        view.addObject("total",total);
        view.setViewName("gouwuche");
        return view;
    }
}
