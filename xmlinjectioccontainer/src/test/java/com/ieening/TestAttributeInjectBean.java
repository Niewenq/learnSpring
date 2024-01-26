package com.ieening;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAttributeInjectBean {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring.xml");
    }

    /**
     * ! 1、使用 set 方法注入
     */
    @Test
    public void testAttributeInjectWithSetter() {
        NormalBean normalBean = classPathXmlApplicationContext.getBean("testAttributeInjectWithSetterNormalBeanId",
                NormalBean.class);
        String expectedString = "NormalBean(attributeInteger=1, attributeString=string attribute, attributeDate=Tue Jan 16 08:25:20 CST 2024, attributeStringArray=[first, second, third], attributeStringSet=[first, second, third], attributeStringList=[first, second, third], attributeMap={first=One, second=Two, third=Three}, attributeProperties={third=three, first=One, second=Two}, customBean=CustomBean(attributeInteger=1))";
        assertEquals(expectedString, normalBean.toString());
    }

    /**
     * ! 2、使用构造器方法注入
     */
    @Test
    public void testAttributeInjectWithConstructor() {
        NormalBean normalBean = classPathXmlApplicationContext.getBean("testAttributeInjectWithConstructorNormalBeanId",
                NormalBean.class);
        String expectedString = "NormalBean(attributeInteger=1, attributeString=string attribute, attributeDate=Tue Jan 16 08:25:20 CST 2024, attributeStringArray=[first, second, third], attributeStringSet=[first, second, third], attributeStringList=[first, second, third], attributeMap={first=One, second=Two, third=Three}, attributeProperties={third=three, first=One, second=Two}, customBean=CustomBean(attributeInteger=1))";
        assertEquals(expectedString, normalBean.toString());
    }

    /**
     * ! 3、使用自动注入
     */
    @Test
    public void testAttributeInjectWithAutoWire() {
        NormalBean normalBean = classPathXmlApplicationContext.getBean("testAttributeInjectWithAutoWireNormalBeanId",
                NormalBean.class);
        String expectedString = "NormalBean(attributeInteger=null, attributeString=null, attributeDate=null, attributeStringArray=null, attributeStringSet=null, attributeStringList=null, attributeMap=null, attributeProperties={third=three, first=One, second=Two}, customBean=CustomBean(attributeInteger=1))";
        assertEquals(expectedString, normalBean.toString());
    }

    @After
    public void tearDown() {
        if (classPathXmlApplicationContext != null) {
            classPathXmlApplicationContext.close();
        }
    }

}
