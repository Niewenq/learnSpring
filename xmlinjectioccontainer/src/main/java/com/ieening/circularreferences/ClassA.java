package com.ieening.circularreferences;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public class ClassA {
    private ClassB classB;

    @Autowired
    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}
