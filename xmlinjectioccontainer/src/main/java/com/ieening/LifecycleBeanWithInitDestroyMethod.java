package com.ieening;

public class LifecycleBeanWithInitDestroyMethod {
    private static boolean afterPropertiesSet = false;

    public static void setAfterPropertiesSet(boolean afterPropertiesSet) {
        LifecycleBeanWithInitDestroyMethod.afterPropertiesSet = afterPropertiesSet;
    }

    public static boolean isAfterPropertiesSet() {
        return afterPropertiesSet;
    }

    private static boolean destroy = false;

    public static void setDestroy(boolean destroy) {
        LifecycleBeanWithInitDestroyMethod.destroy = destroy;
    }

    public static boolean isDestroy() {
        return destroy;
    }

    public void init() {
        afterPropertiesSet = true;
    }

    public void destroy() {
        destroy = true;
    }

}
