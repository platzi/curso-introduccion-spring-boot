package com.platzi.springboot.services;

import com.platzi.springboot.bean.MyOperation;

public class MyBeanWithDependenciesImpl implements BeanWithDependencies {
    private MyOperation myOperation;

    public MyBeanWithDependenciesImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public int operationWithDependencies() {
        int value = 0;
        value = myOperation.sumOne(value);
        return value;
    }
}
