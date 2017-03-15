package com.nokia.training.d01.s02;

import java.util.*;

public class IteratorTests {

    public static void main(String[] args) {
        //lists();

        sets();
    }

    private static void sets() {
        Set<Product> products = new HashSet<>();
        products.add(new Product(20, "x", 10));
        products.add(new Product(50, "y", 20));
        products.add(new Product(10, "z", 50));

        Iterator<Product> productsIterator = products.iterator();

        while (productsIterator.hasNext()) {
            Product element = productsIterator.next();

            if (element.getId() < 20) {
                productsIterator.remove();
            }

            //System.out.println(element);
        }

        System.out.println(products);
    }

    private static void lists() {
        List<String> strings = new ArrayList<>(Arrays.asList("iterating", "over", "a", "list"));

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String nextElement = iterator.next();
            //System.out.println(nextElement);

            if (nextElement.length() < 3) {
                iterator.remove();
            }
        }

        System.out.println(strings);
    }
}
