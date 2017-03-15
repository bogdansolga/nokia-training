package com.nokia.training.d01.s01;

import java.util.List;

public class ProductProcessor {

    public static <Object> void process(List<Object> products) {

    }

    public static <Type extends Product> void
            processProductHierarchy(List<Type> products) {

    }

    public void processProducts(List<?> items) {

    }
}
