package com.booleanuk.core;

public abstract class Product {
    private String sku;
    private double price;
    private String name;
    private String variant;

    public Product(String sku, double price, String name, String variant) {
        setSku(sku);
        setPrice(price);
        setName(name);
        setVariant(variant);
    }

    // Getters
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    // Setters - private
    private void setSku(String sku) {
        this.sku = sku;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setVariant(String variant) {
        this.variant = variant;
    }
}
