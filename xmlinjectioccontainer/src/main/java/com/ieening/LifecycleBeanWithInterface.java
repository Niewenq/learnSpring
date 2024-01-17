package com.ieening;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LifecycleBeanWithInterface implements InitializingBean, DisposableBean {
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    private boolean afterPropertiesSet = false;
    private boolean destroy = false;

    @Override
    public void destroy() throws Exception {
        destroy = true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        afterPropertiesSet = true;
    }

    public LifecycleBeanWithInterface() {
        count += 1;
    }

}
