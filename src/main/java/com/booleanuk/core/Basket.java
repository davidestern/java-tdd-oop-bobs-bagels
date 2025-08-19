package com.booleanuk.core;

import java.util.List;

public class Basket {
    private List<Product> products;
    private static int capacity = 10;

    public Basket(List<Product> products) {
        setProducts(products);
    }

    public void addProduct(Product product) {

    }

    public void removeProduct(String productSku) {

    }

    public Boolean isFull() {
        return null;
    }

    public double getTotalCost() {
        return 0;
    }

    public List<Product> getProducts() {
        return products;
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        Basket.capacity = capacity;
    }
}
