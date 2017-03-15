package com.nokia.training.d02.s02;

import java.util.LinkedList;
import java.util.List;

public class ProductService {

    private List<Product> products = new LinkedList<>();

    public void addProduct(final Product product) {
        final int productId = product.getId();
        final Product searchedProduct = getProductById(productId);
        if (searchedProduct != null) {
            throw new IllegalArgumentException("There is already a " +
                    "product with the ID " + productId);
        }

        products.add(product);
        System.out.println("The product was added");
    }

    public Product getProduct(final int id) throws ProductNotFoundException {
        final Product searchedProduct = getProductById(id);
        validateExistingProduct(id, searchedProduct);

        return searchedProduct;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void updateProduct(final int id, final Product newProduct) throws ProductNotFoundException {
        final Product product = getProductById(id);
        validateExistingProduct(id, product);

        products.remove(product);
        products.add(newProduct);
    }

    public void deleteProduct(final int id) throws ProductNotFoundException {
        final Product product = getProductById(id);
        validateExistingProduct(id, product);

        products.remove(product);
    }

    private Product getProductById(int id) {
        Product searchedProduct = null;
        for (Product product : products) {
            if (product.getId() == id) {
                searchedProduct = product;
            }
        }

        return searchedProduct;
    }

    private void validateExistingProduct(final int id, final Product searchedProduct)
            throws ProductNotFoundException {
        if (searchedProduct == null) {
            throw new ProductNotFoundException("There is no product with the ID " + id);
        }
    }
}
