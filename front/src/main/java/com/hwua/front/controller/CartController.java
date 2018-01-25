package com.hwua.front.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.common.po.Address;
import com.hwua.common.po.Cart;
import com.hwua.common.po.Member;
import com.hwua.common.po.Product;
import com.hwua.front.service.AddressService;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private AddressService addressService;




    //添加到购物车
    @RequestMapping(value = "/addToCart",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addToCart(int pid, int count, HttpSession session){
        System.out.println("pid = [" + pid + "], count = [" + count + "]");
        Member member = (Member) session.getAttribute("member");
        int mid = member.getMid();
        JSONObject jsonObject = new JSONObject();
        List<Cart> unchecked = cartService.getUnchecked(mid, pid);
        System.out.println("unchecked = " + unchecked);
        if (unchecked.size() == 0){
            //不存在该商品
            int i = cartService.AddToCart(mid, pid, count);
//            session.setAttribute("count",count);
            if (i == 1){
                //添加成功
                jsonObject.put("flag",true);
            }else {
                //添加失败
                jsonObject.put("flag",false);
            }
        }else {
            //存在，执行修改数量
            //原数量
            int count1 = cartService.getCount(mid, pid);
            //相加后的数量
            count = count1 + count;
            //修改
            int i = cartService.updateCount(mid, pid, count);
//            session.setAttribute("count",count);
            if (i == 1){
                //添加成功
                jsonObject.put("flag",true);
            }else {
                //添加失败
                jsonObject.put("flag",false);
            }
        }
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/delProductIncart",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String delProductIncart(int pid,int mid){
        System.out.println("pid****************************** = [" + pid + "], mid = [" + mid + "]");
        int i = cartService.delProductInCart(mid, pid);
        JSONObject jsonObject = new JSONObject();
        if (i==1){
            jsonObject.put("flag",true);
        }else {
            jsonObject.put("flag",false);
        }
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/updateCount",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateCount(int mid,int pid,int count){
        System.out.println("mid = [" + mid + "], pid = [" + pid + "], count = [" + count + "]");
        int i = cartService.updateCount(mid, pid, count);
        JSONObject jsonObject = new JSONObject();
        if (i == 1){
            //添加成功
            jsonObject.put("flag",true);
        }else {
            //添加失败
            jsonObject.put("flag",false);
        }
        return jsonObject.toJSONString();
    }


    @RequestMapping(value = "/updateCartType",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateCartType(int mid,int pid,int type){
        System.out.println("mid = [" + mid + "], pid = [" + pid + "], type = [" + type + "]");
        int i = cartService.updateCartType(mid, pid, type);
        JSONObject jsonObject = new JSONObject();
        if (i == 1){
            jsonObject.put("flag",true);
            jsonObject.put("msg","success");
        }else {
            jsonObject.put("flag",false);
            jsonObject.put("msg","fail");
        }
        return jsonObject.toJSONString();
    }

    //购物车点击  去结算  跳到  结算页面,查询待结算的商品信息及价格等
    @RequestMapping(value = "/balance",produces = "application/json;charset=utf-8")
    public ModelAndView balance(HttpSession session){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        List<Map<String, Object>> balanceList = productService.getType0(mid);
        System.out.println("balanceList = " + balanceList);
        ModelAndView view = new ModelAndView();
        int total = 0;
        int i = 0;

        //如果购物车没商品，则会让购物
        if(balanceList.size()==0){
            return new ModelAndView("redirect:/toMain");
        }

        for (i=0;i<balanceList.size();i++){
            Map<String, Object> map1 = balanceList.get(i);
            Integer count = (Integer) map1.get("count");
            Integer selprice = (Integer) map1.get("SELPRICE");
            total += (count*selprice);
        }
        //查找地址，添加地址
        Address defaultAddr = addressService.getDefaultAddr(mid);
        if(defaultAddr == null){
            //添加地址
            return new ModelAndView("addAddress");
        }
        String addr = defaultAddr.getAddr();


        view.addObject("addr",addr);
        view.addObject("balanceList",balanceList);
        view.addObject("total",total);
        session.setAttribute("total",total);
        view.addObject("i",i);
        view.setViewName("balance");
        return view;
    }



    @RequestMapping("/getUnPay")
    public ModelAndView getUnPay(HttpSession session){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        List<Map<String, Object>> status0 = cartService.getStatus0(mid);
        ModelAndView view = new ModelAndView();
        view.addObject("status0",status0);
        view.setViewName("daifukuan");
        return view;
    }


}
