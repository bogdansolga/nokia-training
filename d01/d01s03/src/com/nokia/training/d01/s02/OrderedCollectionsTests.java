package com.nokia.training.d01.s02;

import java.util.*;

public class OrderedCollectionsTests {

    public static void main(String[] args) {
        //lists();

        //sets();

        maps();
    }

    private static void maps() {
        Map<Product, Integer> stock = new TreeMap<>();

        stock.put(new Product(20, "x", 10), 20);
        stock.put(new Product(50, "y", 20), 10);
        stock.put(new Product(10, "z", 50), 30);

        for (Product product : stock.keySet()) {
            System.out.println(product + " -> " + stock.get(product));
        }
    }

    private static void sets() {
        Set<Product> products = new TreeSet<>();

        products.add(new Product(20, "x", 10));
        products.add(new Product(50, "y", 20));
        products.add(new Product(10, "z", 50));

        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void lists() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(20, "x", 20));
        products.add(new Product(50, "x", 20));
        products.add(new Product(10, "y", 20));

        Collections.sort(products);

        System.out.println(products);
    }
}
