package com.nokia.training.d03.s02;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class XMLSerializationTests {

    private static final Random RANDOM = new Random(1000);

    public static void main(String[] args) {
        //serializingAProductInXML();

        //deSerializingAProductFromXML();

        serializingMultipleProductsInXML();

        //TODO deSerializeCollectionFromXML()
    }

    private static void serializingMultipleProductsInXML() {
        final Set<Product> products = new HashSet<>();

        products.add(createProduct("Laptop", 400));
        products.add(createProduct("Phone", 500));

        try (final XMLEncoder xmlEncoder
                     = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream("products.xml")))) {

            xmlEncoder.writeObject(products);
            xmlEncoder.flush();

            System.out.println("The products XML file was successfully written");
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void deSerializingAProductFromXML() {
        try (final XMLDecoder xmlDecoder
                     = new XMLDecoder(new BufferedInputStream(
                             new FileInputStream("product.xml")))) {

            final Product product = (Product) xmlDecoder.readObject();
            System.out.println(product);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void serializingAProductInXML() {
        try (final XMLEncoder xmlEncoder
                     = new XMLEncoder(new BufferedOutputStream(
                             new FileOutputStream("product.xml")))) {

            final Product product = createProduct("Phone", 500);
            xmlEncoder.writeObject(product);
            xmlEncoder.flush();

            System.out.println("The XML file was successfully written");
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Product createProduct(final String productName, int price) {
        return new Product(RANDOM.nextInt(100), productName, price);
    }
}
