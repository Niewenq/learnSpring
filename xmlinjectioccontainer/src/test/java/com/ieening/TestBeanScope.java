package com.ieening;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanScope {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring_high_order.xml");
    }

    /**
     * ! 1、测试 Singleton 作用域
     */
    @Test
    public void testSingleton() {
        Object firstBean = classPathXmlApplicationContext.getBean("testSingletonScopeBeanId");
        Object secondBean = classPathXmlApplicationContext.getBean("testSingletonScopeBeanId");
        assertEquals(firstBean, secondBean);
    }

    /**
     * ! 2、测试 Prototype 作用域
     */
    @Test
    public void testPrototype() {
        Object firstBean = classPathXmlApplicationContext.getBean("testPrototypeScopeBeanId");
        Object secondBean = classPathXmlApplicationContext.getBean("testPrototypeScopeBeanId");
        assertTrue(firstBean != secondBean);
    }

    @After
    public void tearDown() {
        if (classPathXmlApplicationContext != null) {
            classPathXmlApplicationContext.close();
        }
    }

}
