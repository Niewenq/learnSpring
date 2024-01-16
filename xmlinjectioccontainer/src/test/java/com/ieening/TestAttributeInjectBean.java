package com.ieening;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAttributeInjectBean {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Before
    public void setUp() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
                "spring.xml");
    }

    @Test
    public void testAttributeInject() {
        NormalBean normalBean = classPathXmlApplicationContext.getBean("testAttributeInjectNormalBeanId",
                NormalBean.class);
        assertEquals(
                "NormalBean(attributeInteger=1, attributeString=string attribute, attributeDate=Tue Jan 16 08:25:20 CST 2024, attributeStringArray=null, attributeStringSet=null, attributeStringList=null, attributeMap=null, attributeProperties=null)",
                normalBean.toString());
    }

    @After
    public void tearDown() {
        if (classPathXmlApplicationContext != null) {
            classPathXmlApplicationContext.close();
        }
    }

}
