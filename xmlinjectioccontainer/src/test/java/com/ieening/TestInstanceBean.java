package com.ieening;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInstanceBean {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring_high_order.xml");
    }

    @Test
    public void testInstanceBeanWithConstructor() {
        Object normalBean = classPathXmlApplicationContext.getBean("testInstanceBeanWithConstructorId");
        assertTrue(normalBean instanceof NormalBean);
    }

    @Test
    public void testInstanceBeanWithStaticFactoryMethod() {
        Object normalBean = classPathXmlApplicationContext.getBean("testInstanceBeanWithStaticFactoryMethodId");
        assertTrue(normalBean instanceof NormalBean);
        int attributeInteger = ((NormalBean) normalBean).getCustomBean().getAttributeInteger();
        assertEquals(1, attributeInteger);
    }

    @Test
    public void testInstanceBeanWithInstanceFactoryMethod() {
        Object normalBean = classPathXmlApplicationContext.getBean("testNormalBeanWithInstanceFactoryMethod");
        assertTrue(normalBean instanceof NormalBean);
    }

    @After
    public void tearDown() {
        if (classPathXmlApplicationContext != null) {
            classPathXmlApplicationContext.close();
        }
    }

}
