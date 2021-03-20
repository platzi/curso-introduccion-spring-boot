package com.platzi.springboot.bean.implementation;

import com.platzi.springboot.bean.MyBean;

public class MyBeanTwoImpl implements MyBean {

    @Override
    public String hello() {
        return "Hello from my MyBeanTwoImpl";
    }
}
