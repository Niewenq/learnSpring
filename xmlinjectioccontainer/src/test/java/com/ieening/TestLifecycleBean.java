package com.ieening;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifecycleBean {

    @Test
    public void testLazyInit() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring_high_order.xml");
        assertEquals(0, LifecycleBeanWithInterface.getCount());
        classPathXmlApplicationContext.getBean("testLifecycleBeanWithInterfaceId");
        assertEquals(1, LifecycleBeanWithInterface.getCount());
        classPathXmlApplicationContext.close();
    }

    @Test
    public void testLifecycleBeanWithInterface() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring_high_order.xml");
        LifecycleBeanWithInterface.setAfterPropertiesSet(false);
        ;
        LifecycleBeanWithInterface.setDestroy(false);
        classPathXmlApplicationContext.getBean("testLifecycleBeanWithInterfaceId");
        assertTrue(LifecycleBeanWithInterface.isAfterPropertiesSet());
        classPathXmlApplicationContext.close();
        assertTrue(LifecycleBeanWithInterface.isDestroy());
    }

    @Test
    public void testLifecycleBeanWithInitDestroyMethod() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring_high_order.xml");
        LifecycleBeanWithInitDestroyMethod.setAfterPropertiesSet(false);
        LifecycleBeanWithInitDestroyMethod.setDestroy(false);
        classPathXmlApplicationContext.getBean("testLifecycleBeanWithInitDestroyMethodId");
        assertTrue(LifecycleBeanWithInitDestroyMethod.isAfterPropertiesSet());
        classPathXmlApplicationContext.close();
        assertTrue(LifecycleBeanWithInitDestroyMethod.isDestroy());
    }
}
