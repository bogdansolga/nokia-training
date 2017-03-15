package com.nokia.training.d01.s04;

import java.util.StringTokenizer;

public class StringTokenizerTests {

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer(
                "somewhere, over the rainbow", ",");

        while (tokenizer.hasMoreElements()) {
            String nextToken = tokenizer.nextToken();
            System.out.println(nextToken);
        }
    }
}
