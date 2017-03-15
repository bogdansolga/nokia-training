package com.nokia.training.d01.s02;

import java.util.Arrays;
import java.util.List;

public class ArraysTests {

    public static void main(String[] args) {
        int[] integers = {1, 2, 3, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers);

        Integer[] fixedSize = new Integer[5];
        fixedSize[4] = 4; // ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(fixedSize));

        String[] strings = {"some", "thing"};
        List<String> list = Arrays.asList(strings);
        System.out.println(list);
    }
}
