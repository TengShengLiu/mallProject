package com.hwua.front.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.common.po.Cart;
import com.hwua.common.po.Member;
import com.hwua.common.po.Product;
import com.hwua.front.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


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

    //购物车点击  去结算  跳到  结算页面
    @RequestMapping(value = "/balance",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String balance(int mid){


        JSONObject jsonObject = new JSONObject();




        return jsonObject.toJSONString();
    }


}
