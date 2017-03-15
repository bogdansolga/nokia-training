package com.nokia.training.d01.s04;

public class StringAppendTests {

    public static void main(String[] args) {
        //stringBuilderTests();

        stringBufferTests();
    }

    private static void stringBufferTests() {
        StringBuffer stringBuffer = new StringBuffer("some");
        stringBuffer.append(" thing");

        System.out.println(stringBuffer.toString());
    }

    private static void stringBuilderTests() {
        StringBuilder stringBuilder = new StringBuilder("Welcome");
        stringBuilder.append(" ")
                     .append("to")
                     .append(" ")
                     .append("the Java training");

        //reverse().
        System.out.println(stringBuilder);

        System.out.println(stringBuilder.toString().concat("!"));
    }
}
