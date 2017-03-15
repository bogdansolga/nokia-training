package com.nokia.training.d02.s02;

import java.util.List;

public class ProductServiceTests {

    private static final ProductService productService = new ProductService();

    public static void main(String[] args) {
        // create operations
        createProduct(new Product(10, "Cola", 20));
        createProduct(new Product(15, "Pepsi", 22));

        // read operations
        readAllProducts();
        readProduct(10);
        readProduct(12);
        readProduct(15);

        // update operation
        updateProduct(10, new Product(10, "Another Cola", 25));
        readAllProducts();

        // delete operations
        deleteProduct(10);
        deleteProduct(13);
        readAllProducts();

        /* recommended way of structuring the code
        try {
            happyPath();
        } catch (final Exception ex) {
            unHappyPath();
        }
        */
    }

    private static void deleteProduct(final int id) {
        try {
            productService.deleteProduct(id);
            System.out.println("The product with the ID " + id + " was successfully deleted!");
        } catch (final ProductNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void updateProduct(final int id, final Product product) {
        try {
            productService.updateProduct(id, product);
            System.out.println("The product with the ID " + id + " was successfully updated!");
        } catch (final ProductNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void readProduct(final int id) {
        try {
            final Product product = productService.getProduct(id);
            System.out.println("The product with the ID " + id + " is '" + product + "'");
        } catch (final ProductNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void createProduct(final Product product) {
        productService.addProduct(product);
    }

    private static void readAllProducts() {
        final List<Product> products = productService.getAllProducts();
        System.out.println("There are " + products.size() + " added products");
        for (Product product : products) {
            System.out.println("\t" + product);
        }
    }
}
