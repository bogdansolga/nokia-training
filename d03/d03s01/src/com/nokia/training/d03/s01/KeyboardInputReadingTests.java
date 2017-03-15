package com.nokia.training.d03.s01;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KeyboardInputReadingTests {

    public static void main(String[] args) {
        //readingFromTheKeyboardInTheOldWay();

        readingFromTheKeyboardUsingTheConsoleClass();
    }

    private static void readingFromTheKeyboardUsingTheConsoleClass() {
        final Console console = System.console();
        if (console != null) {
            console.readLine();
        } else {
            final Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }

        //TODO enjoy :)
    }

    private static void readingFromTheKeyboardInTheOldWay() {
        try (final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {
            System.out.println("Please enter your text:");
            final String input = bufferedReader.readLine();

            System.out.println("You have entered '" + input + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
