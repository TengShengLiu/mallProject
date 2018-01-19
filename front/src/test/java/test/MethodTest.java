package test;

import com.hwua.front.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

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

}
