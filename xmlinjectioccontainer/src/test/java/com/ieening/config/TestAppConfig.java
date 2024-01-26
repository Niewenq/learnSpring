package com.ieening.config;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ieening.CustomBean;
import com.ieening.NormalBean;

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

    @After
    public void tearDown() {
        if (annotationConfigApplicationContext != null) {
            annotationConfigApplicationContext.close();
        }
    }
}
