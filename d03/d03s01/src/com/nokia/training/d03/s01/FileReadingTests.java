package com.nokia.training.d03.s01;

import java.io.*;

public class FileReadingTests {

    public static void main(String[] args) {
        final String fileName = System.getProperty("USED_FILE_NAME");
        //readingAFileWithoutAutomaticResourcesClosing(fileName);

        readingAFileWithAutomaticResourcesClosing(fileName);
    }

    private static void readingAFileWithAutomaticResourcesClosing(String fileName) {
        try (final FileReader fileReader = new FileReader(fileName);
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            displayFileContent(bufferedReader);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void readingAFileWithoutAutomaticResourcesClosing(
            final String fileName) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            displayFileContent(bufferedReader);
        } catch (final FileNotFoundException ex) {
            System.err.println("The file was not found");
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }

                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void displayFileContent(final BufferedReader bufferedReader)
            throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
