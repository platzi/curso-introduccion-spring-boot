package com.platzi.springboot.bean.implementation;

import com.platzi.springboot.bean.MyOperation;

public class MyOperationImpl implements MyOperation {
    @Override
    public int sumOne(int value) {
        return value+1;
    }
}
