package com.nokia.training.d03.s02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializingTests {

    public static void main(String[] args) {
        //serializeAProduct();

        deSerializeAProduct();
    }

    private static void deSerializeAProduct() {
        try (final FileInputStream fileInputStream =
                     new FileInputStream("apa.ser");
             final ObjectInputStream objectInputStream =
                     new ObjectInputStream(fileInputStream)) {

            final Product product = (Product) objectInputStream.readObject();
            System.out.println(product);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void serializeAProduct() {
        try (final FileOutputStream fileOutputStream =
                     new FileOutputStream("apa.ser");
             final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(fileOutputStream)) {

            final Product product = createProduct();
            objectOutputStream.writeObject(product);

            System.out.println("OK");
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Product createProduct() {
        return new Product(10, "Apă", 1);
    }
}
