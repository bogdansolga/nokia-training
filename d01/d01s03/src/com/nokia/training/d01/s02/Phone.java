package com.nokia.training.d01.s02;

import java.util.Objects;

public class Phone extends Product {

    private String producer;

    public Phone(int id, String name, double price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        Phone phone = (Phone) other;
        return Objects.equals(producer, phone.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), producer);
    }
}
