package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class BasketTest {

    @Test
    public void addProductNotExistingInInventoryShouldThrow() {
        Basket b = new Basket(new LinkedList<>());

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.addProduct(new Bagel("NotExistingProduct", 0, " ", " ")));
    }

    @Test
    public void addProductThatExistsInInventory() {
        Basket b = new Basket(new LinkedList<>());
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));

        Assertions.assertEquals("Bagel", b.getProducts().getFirst().getName());
    }

    @Test
    public void removeItemNotInBasketShouldThrow() {
        Basket b = new Basket(new LinkedList<>());

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.removeProduct("NotExistingProduct"));
    }

    @Test
    public void removeProductExistingInBasket() {
        Basket b = new Basket(new LinkedList<>());
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.removeProduct("BGLO");

        Assertions.assertTrue(b.getProducts().isEmpty());
    }

    @Test
    public void isFullReturnsFalseWhenNotFull() {
        Basket b = new Basket(new LinkedList<>());

        Assertions.assertFalse(b.isFull());
    }

    @Test
    public void isFullReturnsTrueWhenFull() {
        Basket b = new Basket(new LinkedList<>());
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));

        Assertions.assertTrue(b.isFull());
    }

    @Test
    public void totalCostShouldBeZeroForEmptyBasket() {
        Basket b = new Basket(new LinkedList<>());

        Assertions.assertEquals(0, b.getTotalCost());
    }

    @Test
    public void totalCostShouldAddUp() {
        Basket b = new Basket(new LinkedList<>());
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.addProduct(new Coffee("COFC", 1.29, "Coffee", "Capuccino"));

        Assertions.assertEquals(1.78, b.getTotalCost());
    }

    @Test
    public void setCapacityCannotBeBelowZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Basket.setCapacity(-20));
    }

    @Test
    public void setCapacityAboveZero() {
        Basket.setCapacity(20);
        Assertions.assertEquals(20, Basket.getCapacity());
    }
}
