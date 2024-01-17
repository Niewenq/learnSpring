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

    private static boolean afterPropertiesSet = false;

    public static void setAfterPropertiesSet(boolean afterPropertiesSet) {
        LifecycleBeanWithInterface.afterPropertiesSet = afterPropertiesSet;
    }

    public static boolean isAfterPropertiesSet() {
        return afterPropertiesSet;
    }

    private static boolean destroy = false;

    public static void setDestroy(boolean destroy) {
        LifecycleBeanWithInterface.destroy = destroy;
    }

    public static boolean isDestroy() {
        return destroy;
    }

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
