package com.nokia.training.d01.s01;

public class ProductDisplayer<Type extends Product> {

    public void display(Type type) {
        System.out.println(type);
    }
}
