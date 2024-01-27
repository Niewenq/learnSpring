package com.ieening.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.ieening.CustomBean;
import com.ieening.NormalBean;
import com.ieening.circularreferences.ClassA;
import com.ieening.circularreferences.ClassB;

@Configuration
public class AppConfig {

    @Bean
    @DependsOn({ "getCustomBean" })
    public NormalBean getNormalBean(CustomBean customBean) {
        return new NormalBean(customBean);
    }

    @Bean
    public CustomBean getCustomBean() {
        return new CustomBean(1);
    }

    @Bean
    public ClassA getClassA() {
        return new ClassA();
    }

    @Bean
    public ClassB getClassB() {
        return new ClassB();
    }

}