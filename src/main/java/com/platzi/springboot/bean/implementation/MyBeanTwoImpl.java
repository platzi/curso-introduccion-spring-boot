package com.platzi.springboot.bean.implementation;

import com.platzi.springboot.bean.MyBean;

public class MyBeanTwoImpl implements MyBean {

    private String name;

    public MyBeanTwoImpl(String name) {
        this.name = name;
    }

    @Override
    public String hello() {
        return "Hello from my MyBeanTwoImpl with name " + name;
    }
}
