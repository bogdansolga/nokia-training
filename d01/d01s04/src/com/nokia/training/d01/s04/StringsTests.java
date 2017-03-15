package com.nokia.training.d01.s04;

import java.util.Arrays;

public class StringsTests {

    public static void main(String[] args) {
        String firstString = "Welcome to the Java training!";

        System.out.println(firstString.substring(0, 3));
        System.out.println(firstString.substring(8));
        System.out.println(firstString);

        /*
        String[] words = firstString.split(" ");
        System.out.println(Arrays.asList(words));

        System.out.println(firstString.indexOf("the"));
        System.out.println(firstString.substring(0, 7));
        System.out.println(firstString.length());

        System.out.println(firstString.toLowerCase());
        System.out.println(firstString.toUpperCase());
        */
    }
}
