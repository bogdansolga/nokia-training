package com.nokia.training.d03.s01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamsMain {
    public static void main(String[] args) throws IOException {
        displayFileContentWithManualStreamClosing();

        //displayFileContentWithAutomaticStreamClosing();

        //readingFromTheKeyboard();
    }

    private static void readingFromTheKeyboard() throws IOException {
        // creating a buffered character stream reader, wrapping the System.in stream with an InputStream reader
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String text = bufferedReader.readLine();  // reading a text from the keyboard

        System.out.println("You have entered '" + text + "'");

        //TODO reading using System.console()
    }

    private static void displayFileContentWithAutomaticStreamClosing() {
        // try with resources will close all the resources passed between the parenthesis
        // the preferred way to handle streams; use manual closing *only* if needed

        try (FileReader fileReader = new FileReader("a simple text file.txt");     // try with resources
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {  // --> automatic resources closing

            String line;
            while ((line = bufferedReader.readLine()) != null) {            // 3 - reading each line from the buffered stream
                System.out.println(line);                                   // 4 - displaying the line
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void displayFileContentWithManualStreamClosing()
            throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            //FIXME do not use a hard-coded file name
            fileReader = new FileReader("a simple text file.txt");  // 1 - reading the file
            bufferedReader = new BufferedReader(fileReader);                // 2 - buffering the file content in memory

            String line;
            while ((line = bufferedReader.readLine()) != null) {            // 3 - reading each line from the buffered stream
                System.out.println(line);                                   // 4 - displaying the line
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();                                     // 5 - closing the buffered reader
            }

            if (fileReader != null) {
                fileReader.close();                                         // 6 - closing the file reader
            }
        }
    }
}