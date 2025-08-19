package com.booleanuk.core;

import java.util.Map;

public class Inventory implements IInventory{
    private final Map<String, Product> inventory;

    public Inventory(Map<String, Product> inventory) {
        this.inventory = inventory;
    }

    @Override
    public Boolean hasProduct(String productSku) {
        return inventory != null && inventory.containsKey(productSku);
    }

    @Override
    public Map<String, Product> getInventory() {
        return inventory;
    }
}
