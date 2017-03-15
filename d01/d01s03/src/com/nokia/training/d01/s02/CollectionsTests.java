package com.nokia.training.d01.s02;

import java.util.*;

public class CollectionsTests {

    public static void main(String[] args) {
        //listsTests();

        //setsTests();
        
        mapsTests();
    }

    private static void mapsTests() {
        Map<String, Integer> months = new HashMap<>();
        months.put("January", 1);
        months.put("March", 3);
        months.put("March", 6);

        //months.put(null, 10); don't do that
        //months.put(null, 11);

        //System.out.println(months);

        for (String key : months.keySet()) {
            System.out.println(key + " -> " + months.get(key));
        }

        months.replace("March", 4); // >= JDK 1.8
        months.remove("January");

        for (Map.Entry<String, Integer> entry : months.entrySet()) {
            System.out.println(entry.getKey());
        }

        Map<String, List<String>> map = new HashMap<>();
    }

    private static void setsTests() {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("one");

        //System.out.println(strings);
        //System.out.println(strings.isEmpty());

        Set<Product> products = new HashSet<Product>();
        products.add(new Product(5, "Box", 10));
        //System.out.println(products);

        Set<Integer> orderedSet = new LinkedHashSet<>();
        orderedSet.addAll(Arrays.asList(5, 8, 3, 10, 26, 45));
        System.out.println(orderedSet);

        Set<Integer> autoOrdered = new TreeSet<>();
        autoOrdered.addAll(orderedSet);
        System.out.println(autoOrdered);
    }

    private static void listsTests() {
        List<String> strings = new ArrayList<>();
        strings.add("some");
        strings.addAll(Arrays.asList("another", "one"));
        strings.add("some");

        System.out.println("Before removing: " + strings);
        System.out.println(strings.remove("some"));
        System.out.println("After removing: " + strings);

        List<Product> products = new ArrayList<>();
        products.add(new Product(10, "iSomething", 25));
        products.add(new Product(15, "Cosmetics", 50));

        System.out.println(products);
    }
}
