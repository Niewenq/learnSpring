package com.ieening.config;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ieening.CustomBean;
import com.ieening.NormalBean;
import com.ieening.circularreferences.ClassA;
import com.ieening.circularreferences.ClassB;

public class TestAppConfig {
    private AnnotationConfigApplicationContext annotationConfigApplicationContext;

    @Before
    public void setUp() {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testGetBean() {
        Object bean = annotationConfigApplicationContext.getBean("getCustomBean");
        assertTrue(bean instanceof CustomBean);
    }

    @Test
    public void testDependsOn() {
        NormalBean bean = annotationConfigApplicationContext.getBean("getNormalBean", NormalBean.class);
        assertTrue(1 == bean.getCustomBean().getAttributeInteger());
    }

    @Test
    public void testGetClassA() {
        ClassA bean = annotationConfigApplicationContext.getBean("getClassA", ClassA.class);
        assertTrue(bean.getClassB() instanceof ClassB);
    }

    @Test
    public void testGetClassB() {
        ClassB bean = annotationConfigApplicationContext.getBean("getClassB", ClassB.class);
        assertTrue(bean.getClassA() instanceof ClassA);
    }

    @After
    public void tearDown() {
        if (annotationConfigApplicationContext != null) {
            annotationConfigApplicationContext.close();
        }
    }
}
