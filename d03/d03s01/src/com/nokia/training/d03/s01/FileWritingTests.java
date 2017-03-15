package com.nokia.training.d03.s01;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWritingTests {

    public static void main(String[] args) {
        writeTextToFile();
    }

    private static void writeTextToFile() {
        try (final FileWriter fileWriter = new FileWriter("output.txt");
             final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("something");
            bufferedWriter.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
