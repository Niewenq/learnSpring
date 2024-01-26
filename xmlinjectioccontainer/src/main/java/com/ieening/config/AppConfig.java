package com.ieening.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.ieening.CustomBean;
import com.ieening.NormalBean;

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
}