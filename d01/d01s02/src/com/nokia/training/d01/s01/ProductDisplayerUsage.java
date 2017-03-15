package com.nokia.training.d01.s01;

public class ProductDisplayerUsage {

    public static void main(String[] args) {
        displayGenericProduct();

        displayProductHierarchy();
    }

    private static void displayProductHierarchy() {
        ProductDisplayer<Cosmetic> cosmeticProductDisplayer = new ProductDisplayer<>();
        ProductDisplayer<Product> genericProductDisplayer = new ProductDisplayer<>();
    }

    private static void displayGenericProduct() {
        Displayer<Product> displayer = new Displayer<Product>();

        Product product = new Product();
        product.setId(5);
        product.setName("iSomething");
        product.setPrice(50000);

        displayer.display(product);
    }
}
