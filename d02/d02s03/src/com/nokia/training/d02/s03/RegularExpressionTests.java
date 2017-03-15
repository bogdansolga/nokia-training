package com.nokia.training.d02.s03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTests {

    public static void main(String[] args) {
        //simpleRegularExpressions();

        matchingGroups();
    }

    private static void matchingGroups() {
        Pattern datePattern = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
        Matcher matcher = datePattern.matcher("14/03/2017");
        if (matcher.matches()) {
            System.out.println("Full group - " + matcher.group(0));

            int day   = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int year  = Integer.parseInt(matcher.group(3));

            System.out.println("Day: " + day + ", month: " + month + ", year: " + year);
        } else {
            System.err.println("Doesn't match");
        }
    }

    private static void simpleRegularExpressions() {
        System.out.println("3".matches("\\d"));
        System.out.println("regex".matches("\\w+"));

        System.out.println("a".matches("[abc]"));
        System.out.println("b".matches("[abc]"));
        System.out.println("d".matches("[abc]"));

        System.out.println("e".matches("[ef]{1}"));
        System.out.println("ee".matches("[ef]{1}"));
    }
}
