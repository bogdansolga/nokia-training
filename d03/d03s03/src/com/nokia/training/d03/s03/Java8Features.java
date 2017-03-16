package com.nokia.training.d03.s03;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8Features {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //java8Overview();

        //inferredFunctionalInterfaces();

        //predicates();
        //consumers();
        //functions();
        //suppliers();

        //biFunctionalInterfaces();
        //typedFunctionalInterfaces();

        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> "It works");
        System.out.println(completableFuture.get());
        System.out.println("Push");
    }

    private static void typedFunctionalInterfaces() {
        LongPredicate longPredicate = it -> it > 0;
        longPredicate.test(15L);
    }

    private static void biFunctionalInterfaces() {
        BiPredicate<String, Integer> predicate = (first, second) ->
                first.length() > 0 && second > 0;

        BiConsumer<String, Integer> consumer = (x, y) -> System.out.println(x + " " + y);
        BiFunction<Integer, String, Product> productBuilder = (price, name) ->
                new Product(10, name, price);

        final Map<Integer, String> map = new HashMap<>();
        map.put(1, "Jan");
        map.put(2, "Feb");

        map.forEach((key, value) -> System.out.println(key + " -> " + value));
        map.computeIfAbsent(3, key -> "Mar");

        List<String> strings = new ArrayList<>(Arrays.asList("fun", "interfaces"));
        strings.forEach(System.out::println);
        strings.removeIf(item -> item.length() < 5);
        System.out.println(strings);
    }

    private static void suppliers() {
        Supplier<Integer> integerSupplier = () -> new Random(50).nextInt(10);
        System.out.println(integerSupplier.get());
    }

    private static void functions() {
        Function<String, Integer> converter = Integer::parseInt;
        //System.out.println(converter.apply("26"));
        //System.out.println(converter.apply("xx"));

        Function<String, Product> productConverter = string -> {
            Predicate<String> isValid = it -> it.length() > 0;
            if (!isValid.test(string)) {
                throw new IllegalArgumentException("Not valid");
            }

            final int price = converter.apply(string.substring(0, 3));
            final String name = string.substring(4, 10);

            return new Product(5, name, price);
        };

        Function<String, String> aLongerFunction = value -> {
            if (value.length() > 5) {
                return value + " ceva";
            } else {
                return value.substring(3);
            }
        };
    }

    private static void consumers() {
        Consumer<String> display = value -> System.out.println("The value is " + value);
        display.accept("Java 8, FTW");

        Consumer<Integer> square = it -> System.out.println(it + "^2 = " + (it * it));
        square.accept(6);
    }

    private static void inferredFunctionalInterfaces() {
        Runnable runnable = () -> System.out.println("it works!");
        runnable.run();

        //Comparable<String> comparable = value -> value.length();

        OurFunctionalInterface ourInterface = String::length;
        System.out.println(ourInterface.computeValue("something"));
    }

    private static void predicates() {
        Predicate<Integer> isEven = value -> value %2 == 0;
        Predicate<Integer> isBiggerThan100 = value -> value > 100;

        System.out.println(isEven.test(12));

        System.out.println(isEven.and(isBiggerThan100).test(140));
    }

    private static void java8Overview() {
        final List<String> strings = Arrays.asList("Java 8 rules!".split(" "));

        // pre Java 8
        for (String string : strings) {
            System.out.println(string);
        }

        // Java 8
        //strings.forEach(string -> System.out.println(string));
        strings.forEach(System.out::println);

        final Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.length() < 5) {
                iterator.remove();
            }
        }

        strings.removeIf(string -> string.length() < 5);
        strings.removeIf(String::isEmpty);

        final Set<String> lessThan5Chars = strings.stream()
                                                  .filter(it -> it.length() < 5)
                                                  .collect(Collectors.toSet());

        final Set<String> emptyChars = strings.stream()
                                              .filter(String::isEmpty)
                                              .collect(Collectors.toSet());

        List<String> integers = Arrays.asList("1", "2", "5");
        Set<Integer> evenNumbers = integers.stream()
                                           .filter(it -> Integer.parseInt(it) %2 == 0)
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toSet());
    }
}
