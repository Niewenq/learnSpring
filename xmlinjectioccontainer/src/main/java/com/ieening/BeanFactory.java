package com.ieening;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BeanFactory {

    public NormalBean createNormalBean() {
        return new NormalBean();
    }
}
