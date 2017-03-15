package com.nokia.training.d01.s02;

public class EqualsAndHashcodeTests {

    public static void main(String[] args) {
        Product product = new Product(10, "Phone", 25);
        System.out.println(product.hashCode());

        Product anotherProduct = new Product(10, "Phone", 25);
        System.out.println(product.equals(anotherProduct));
        System.out.println(anotherProduct.hashCode());

        Product nullProduct = null;
        System.out.println(product.equals(nullProduct));
    }
}
