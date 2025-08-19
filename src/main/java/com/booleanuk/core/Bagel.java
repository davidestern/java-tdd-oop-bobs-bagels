package com.booleanuk.core;

import java.util.List;

public class Bagel extends Product {
    List<Filling> fillings;

    public Bagel(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
    }

    public void addFilling(Filling filling) {

    }

    public double getTotalPrice() {
        return 0;
    }

    public List<Filling> getFillings() {
        return this.fillings;
    }
}
