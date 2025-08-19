package com.booleanuk.core;

import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class BaseTest {
    protected static IInventory inventory;

    @BeforeAll
    static void setUpInventory() {
        inventory = new Inventory(Map.ofEntries(
                Map.entry("BGLO", new Bagel("BGLO", 0.49, "Bagel", "Onion")),
                Map.entry("BGLP", new Bagel("BGLP", 0.39, "Bagel", "Plain")),
                Map.entry("BGLE", new Bagel("BGLE", 0.49, "Bagel", "Everything")),
                Map.entry("BGLS", new Bagel("BGLS", 0.49, "Bagel", "Sesame")),
                Map.entry("COFB", new Coffee("COFB", 0.99, "Coffee", "Black")),
                Map.entry("COFW", new Coffee("COFW", 1.19, "Coffee", "White")),
                Map.entry("COFC", new Coffee("COFC", 1.29, "Coffee", "Capuccino")),
                Map.entry("COFL", new Coffee("COFL", 1.29, "Coffee", "Latte")),
                Map.entry("FILB", new Filling("FILB", 0.12, "Filling", "Bacon")),
                Map.entry("FILE", new Filling("FILE", 0.12, "Filling", "Egg")),
                Map.entry("FILC", new Filling("FILC", 0.12, "Filling", "Cheese")),
                Map.entry("FILX", new Filling("FILX", 0.12, "Filling", "Cream Cheese")),
                Map.entry("FILS", new Filling("FILS", 0.12, "Filling", "Smoked Salmon")),
                Map.entry("FILH", new Filling("FILH", 0.12, "Filling", "Ham"))
        ));
    }
}
