package com.nokia.training.d03.s02;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable {

    private int id;

    private String name;

    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        //return "The product has the ID " + id + ", the name '" + name + "' and the price " + price;
        return id + "-" + name + "-" + price;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Product product = (Product) other;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;

        result = 31 * result + (name != null ? name.hashCode() : 0);
        long temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(id, o.getId());
        //return name.compareTo(o.getName());
    }
}
