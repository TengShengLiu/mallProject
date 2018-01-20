package com.hwua.front.listener;

import com.hwua.front.service.ProductService;
import com.hwua.common.po.Product;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ProductInit implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        ProductService bean = wac.getBean(ProductService.class);
        List<Product> products = bean.getAll();
        System.out.println("products = " + products);
        servletContext.setAttribute("products",products);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
