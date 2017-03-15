package com.nokia.training.d03.s02;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SerializationMain {

    public static void main(String[] args) {
        //serializeProductInTheClassicFormat();

        //serializeProductInXMLFormat();

        //serializeProductsInXMLFormat();

        //toDo();
    }

    private static void serializeProductInTheClassicFormat() {
        try (final FileOutputStream fileOutputStream =
                     new FileOutputStream("product.ser");
             final ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(fileOutputStream)) {

            final Product product = createProduct();
            objectOutputStream.writeObject(product);

            System.out.println("The product was successfully serialized");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void serializeProductInXMLFormat() {
        try (final XMLEncoder xmlEncoder = new XMLEncoder(
                new BufferedOutputStream(new FileOutputStream("product.xml")))) {

            final Product product = createProduct();
            xmlEncoder.writeObject(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void serializeProductsInXMLFormat() {
        try (final XMLEncoder xmlEncoder = new XMLEncoder(
                new BufferedOutputStream(new FileOutputStream("products.xml")))) {

            final Set<Product> products = new HashSet<>(2);
            final Product first = createProduct();
            first.setName("iPhone 7");

            final Product second = createProduct();
            second.setName("Samsung S8");

            products.addAll(Arrays.asList(first, second));

            xmlEncoder.writeObject(products);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Product createProduct() {
        return new Product(5, "iSomething", 500);
    }

    private static void toDo() {
        /*
            TODO:
                1 - deserialize the classical serialized object
                2 - deserialize the XML serialized object
                3 - deserialize the XML serialized objects

                Recommended structure - create a SerializingService,
                    which contains methods for serializing and de... objects
         */
    }
}
