package com.ieening;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring.xml");
    }

    /**
     * ! 1、通过类获取 bean
     */
    @Test
    public void testGetBeanByClass() {
        NormalBean normalBean = classPathXmlApplicationContext.getBean(NormalBean.class);
        assertTrue(normalBean instanceof NormalBean);
    }

    /**
     * ! 2、通过 xml 配置文件中配置的 Id 获取 Bean
     */
    @Test
    public void testGetBeanById() {
        Object normalBean = classPathXmlApplicationContext.getBean("normalBeanId");
        assertTrue(normalBean instanceof NormalBean);
    }

    /**
     * ! 3、通过 xml 配置文件中配置的 name 获取 Bean
     */
    @Test
    public void testGetBeanByName() {
        Object normalBean = classPathXmlApplicationContext.getBean("normalBeanName");
        assertTrue(normalBean instanceof NormalBean);
    }

    /**
     * ! 4、通过 xml 配置文件中配置的 name 和类获取 Bean
     */
    @Test
    public void testGetBeanByNameAndClass() {
        Object normalBean = classPathXmlApplicationContext.getBean("normalBeanName", NormalBean.class);
        assertTrue(normalBean instanceof NormalBean);
    }

    @After
    public void tearDown() {
        if (classPathXmlApplicationContext != null) {
            classPathXmlApplicationContext.close();
        }
    }
}
