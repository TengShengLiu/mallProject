package com.hwua.front.controller;

import com.hwua.common.po.Member;
import com.hwua.common.po.OrderDetails;
import com.hwua.common.po.Orders;
import com.hwua.front.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;



    @Transactional
    @RequestMapping("/order")
    public ModelAndView balance(HttpSession session){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        ModelAndView view = new ModelAndView();

        //添加订单,获取最新订单id
        int i3 = orderService.addNewOrder(mid);
        int maxId = orderService.getMaxId(mid);
        System.out.println("maxId = " + maxId);
        System.out.println("i3 = " + i3);

        //修改商品库存
        List<Map<String, Integer>> cartPidCount = cartService.getCartPidCount(mid);
        if(cartPidCount != null){
            for (int i = 0;i<cartPidCount.size();i++){
                Map<String, Integer> pidCount = cartPidCount.get(i);
                int i2 = productService.updateInventory(pidCount);
                System.out.println("i2 = " + i2);

                //添加订单详情
                pidCount.put("oid",maxId);
                int i5 = orderDetailService.addNewInfo(pidCount);
                System.out.println("i5 = " + i5);
            }
        }


        //修改个人账户信息

        List<Map<String, Object>> balanceList = productService.getType0(mid);
        double total = 0;
        int i = 0;
        if(balanceList != null){
            for (i=0;i<balanceList.size();i++){
                Map<String, Object> map1 = balanceList.get(i);
                Integer count = (Integer) map1.get("count");
                Integer selprice = (Integer) map1.get("SELPRICE");
                total += (count*selprice);
            }
        }

        memberService.updateAccount(mid,total);


        //修改cart购买商品状态
        List<Integer> cartId = cartService.getCartId(mid);
        int i1 = cartService.updateStatus(cartId);


/*
        List<Map<String, Object>> infoList = productService.getType0(mid);
        System.out.println("infoList = " + infoList);
*/





        view.setViewName("redirect:/orders/getAll");
        return view;
    }

    @RequestMapping(value = "/getAll")
    public ModelAndView getAllOrders(HttpSession session){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        ModelAndView view = new ModelAndView("dingdanzhongxin");
        //带参，跳到订单中心
        List<Orders> orders = orderService.getAll(mid);
        view.addObject("orders",orders);
        List<OrderDetails> orderDetails = orderDetailService.getAll(mid);
        view.addObject("orderDetails",orderDetails);
        return view;
    }

    @RequestMapping("/getUnSend")
    public ModelAndView getUnSend(HttpSession session){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        List<Map<String, Object>> unsends = orderService.getUnsend(mid);
        ModelAndView view = new ModelAndView("daifahuo");
        view.addObject("unsends",unsends);
        return view;
    }

    @RequestMapping("/getUnReceive")
    public ModelAndView getUnReceive(HttpSession session){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        List<Map<String, Object>> unReceives = orderService.getUnReceive(mid);
        ModelAndView view = new ModelAndView("daishouhuo");
        view.addObject("unReceives",unReceives);
        return view;
    }


}
