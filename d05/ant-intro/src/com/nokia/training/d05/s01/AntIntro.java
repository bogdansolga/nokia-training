package com.nokia.training.d05.s01;

import com.nokia.training.d05.s01.model.Product;
import com.nokia.training.d05.s01.service.ProductService;

public class AntIntro {

    public static void main(String[] args) {
        final ProductService productService = new ProductService();
        productService.processProduct(new Product(10, "Tablet"));
    }
}
