package test;

import com.hwua.common.dao.CartMapper;
import com.hwua.common.dao.OrderDetailsMapper;
import com.hwua.common.dao.OrdersMapper;
import com.hwua.common.dao.ProductQueryMapper;
import com.hwua.front.service.MemberService;
import com.hwua.front.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class MethodTest {

    @Test
    public void testMethod1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ProductService bean = ctx.getBean(ProductService.class);
        List<Map<String, Object>> type0 = bean.getType0(7);
        int total = 0;
        int i;
        for(i = 0;i<type0.size();i++){
            Map<String, Object> map = type0.get(i);
            Integer count = (Integer) map.get("count");
            System.out.println("count = " + count);
            Integer selprice = (Integer) map.get("SELPRICE");
            System.out.println("selprice = " + selprice);
            total += (count*selprice);
        }
        System.out.println("i = " + i);
        System.out.println("total = " + total);


    }

    @Test
    public void testMethod(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        /*CartMapper bean = ctx.getBean(CartMapper.class);
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(15);
        integers.add(16);
        int i = 0;
        i += bean.updateStatus(integers);
        System.out.println("i = " + i);*/
        OrdersMapper bean = ctx.getBean(OrdersMapper.class);
        Integer integer = bean.QueryMaxId(7);
        System.out.println("integer = " + integer);

    }

    @Test
    public void testMethod2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        CartMapper bean = ctx.getBean(CartMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mid",7);
        List<Integer> integers = bean.queryCartId(map);
        System.out.println(integers);


    }


    @Test
    public void testMethod3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        CartMapper bean = ctx.getBean(CartMapper.class);
        ProductQueryMapper bean1 = ctx.getBean(ProductQueryMapper.class);
        OrderDetailsMapper bean2 = ctx.getBean(OrderDetailsMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mid",7);
        List<Map<String, Integer>> maps = bean.queryCartPidCount(map);
        for (int i = 0;i<maps.size();i++){
            Map<String, Integer> map1 = maps.get(i);
            int i1 = bean1.updateInventory(map1);
            System.out.println("i1 = " + i1);

            Integer oid = 5;
            map1.put("oid",oid);
            System.out.println("map1 = " + map1);
            int i2 = bean2.addNewInfo(map1);
            System.out.println("i2 = " + i2);

        }

        System.out.println("maps = " + maps);
        System.out.println(maps.size());


    }

    @Test
    public void testMethod11(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        OrderDetailsMapper bean = ctx.getBean(OrderDetailsMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("oid",5);
        map.put("pid",1);
        map.put("count",1);
        map.put("price",3299);
        int i = bean.addNewInfo(map);
        System.out.println("i = " + i);

    }

    @Test
    public void testMethod111(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
        MemberService bean = ctx.getBean(MemberService.class);
        int i = bean.updateAccount(7, 1000);
        System.out.println("i = " + i);

    }

}
