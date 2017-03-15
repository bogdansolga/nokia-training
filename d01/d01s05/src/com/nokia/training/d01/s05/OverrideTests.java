package com.nokia.training.d01.s05;

public class OverrideTests {

    @SuppressWarnings({"deprecation", "unchecked", "unused"})
    public static void main(String[] args) {
        ProductProcessor productProcessor = new ProductProcessorImpl();
        productProcessor.contractEnforce(new Product(10, "Phone"));

        Product notUsedProduct = new Product(10, "x");
    }
}
