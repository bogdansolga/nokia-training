package com.nokia.training.d02.s02;

import java.util.Date;

public class ExceptionsTests {

    private static final int PROCESSOR_CORES = Runtime.getRuntime().availableProcessors();

    private static long EXECUTION_TIME;

    static {
        EXECUTION_TIME = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println("Running at " + new Date(EXECUTION_TIME));
        System.out.println("Using " + PROCESSOR_CORES + " cores");

        try {
            changingExceptionType();

            throwingMethod();

            //parsingAString("23d");
        } catch (Exception e) {
            System.err.println("An exception has occurred - '" + e.getMessage() + "'");
            //e.printStackTrace();
        }
    }

    private static void changingExceptionType() {
        String name = null;

        try {
            System.out.println(name.length());
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Cannot display the length of a null string");
        } finally {
            System.out.println("Will be executed each and every time :)");
        }
    }

    private static double parsingAString(String string) {
        return Double.parseDouble(string);
    }

    private static void throwingMethod() throws Exception {
        if (System.currentTimeMillis() %2 != 0) {
            throw new Exception("Not even");
        }
    }
}
