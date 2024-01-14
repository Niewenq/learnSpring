package org.ieening.controller;

import org.ieening.service.impl.ProductServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProductServiceWithSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring.xml");
        ProductServiceImpl productService = (ProductServiceImpl) classPathXmlApplicationContext
                .getBean("productService");
        productService.getProductById();
        classPathXmlApplicationContext.close();
    }
}
