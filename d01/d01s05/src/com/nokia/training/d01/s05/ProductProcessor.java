package com.nokia.training.d01.s05;

public abstract class ProductProcessor {

    abstract void process(Product product);

    @Deprecated
    void contractEnforce(Product product) {
        System.out.println("From main class - " + product);
    }
}
