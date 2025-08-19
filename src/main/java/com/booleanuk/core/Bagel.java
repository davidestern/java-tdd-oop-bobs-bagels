package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {
    private List<Filling> fillings;

    public Bagel(String sku, double price, String name, String variant) {
        super(sku, price, name, variant);
        this.fillings = new ArrayList<>();
    }

    public double getTotalPrice() {
        double sum = getPrice();
        for (Filling f : fillings) {
            sum += f.getPrice();
        }
        return sum;
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
    }

    public List<Filling> getFillings() {
        return this.fillings;
    }
}
