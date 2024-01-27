package com.ieening.circularreferences;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

@Getter
public class ClassB {
    private ClassA classA;

    @Autowired
    public void setClassA(ClassA classA) {
        this.classA = classA;
    }
}
