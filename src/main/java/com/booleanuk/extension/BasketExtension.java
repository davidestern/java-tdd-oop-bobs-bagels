package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Filling;
import com.booleanuk.core.IInventory;
import com.booleanuk.core.Product;

import java.util.List;

public class BasketExtension {
    private List<Product> products;
    private static int capacity = 100;
    private final IInventory inventory;

    public BasketExtension(List<Product> products, IInventory inventory) {
        this.inventory = inventory;
        setProducts(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (inventory == null || !inventory.hasProduct(product.getSku())) {
            throw new IllegalArgumentException("Product does not exist in inventory");
        }
        if (products.size() >= capacity) {
            throw new IllegalArgumentException("Basket is already full");
        }
        products.add(product);
    }

    public void addFilling(Bagel bagel, Filling filling) {
        if (bagel == null) throw new IllegalArgumentException("Bagel is null");
        if (filling == null) throw new IllegalArgumentException("Filling is null");
        if (inventory == null) throw new IllegalStateException("inventory not configured");
        if (!products.contains(bagel)) throw new IllegalStateException("Bagel is not currently in baskset");
        if (!inventory.hasProduct(filling.getSku())) throw new IllegalArgumentException("Unknown SKU: " + filling.getSku());
        if (!filling.getName().equals("Filling")) throw new IllegalArgumentException("Product is not a filling");
        bagel.addFilling(filling);
    }

    public void removeProduct(String productSku) {
        if (productSku == null) {
            throw new IllegalArgumentException("SKU is null");
        }
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (productSku.equals(p.getSku())) {
                products.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Product not in basket: " + productSku);
    }

    public double getTotalCost() {
        DiscountCalculator dc = new DiscountCalculator(products);
        double sum = 0;
        for (Product p : products) {
            if (p instanceof Bagel) {
                for (Filling f : ((Bagel) p).getFillings()) {
                    sum += f.getPrice();
                }
            } else {
                sum += p.getPrice();
            }
        }
        return sum + dc.calculateDiscountedPrice();
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
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        BasketExtension.capacity = capacity;
    }
}
