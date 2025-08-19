package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BasketTest extends BaseTest {

    @Test
    public void addProductNotExistingInInventoryShouldThrow() {
        Basket b = new Basket(new ArrayList<>(), inventory);

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.addProduct(new Bagel("NotExistingProduct", 0, " ", " ")));
    }

    @Test
    public void addProductThatExistsInInventory() {
        Basket b = new Basket(new ArrayList<>(), inventory);
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));

        Assertions.assertEquals("Bagel", b.getProducts().getFirst().getName());
    }

    @Test
    public void addProductWhenBasketIsFullShouldThrow() {
        Basket b = new Basket(new ArrayList<>(), inventory);
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

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion")));
    }

    @Test
    public void addFillingNotExistingShouldThrow() {
        Basket b = new Basket(new ArrayList<>(), inventory);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        b.addProduct(bagel);

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.addFilling((Bagel) b.getProducts().getFirst(), new Filling("Not existing filling", 0, " ", " ")));
    }

    @Test
    public void addFillingToBagelNotInBasketShouldThrow() {
        Basket b = new Basket(new ArrayList<>(), inventory);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertThrows(IllegalStateException.class, () -> b.addFilling(bagel, new Filling("FILB", 0.12, "Filling", "Bacon")));
    }

    @Test
    public void addFillingButFillingIsAnotherProductTypeShouldThrow() {
        Basket b = new Basket(new ArrayList<>(), inventory);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        b.addProduct(bagel);

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.addFilling((Bagel) b.getProducts().getFirst(), new Filling("COFC", 1.29, "Coffee", "Capuccino")));
    }

    @Test
    public void addExistingFilling() {
        Basket b = new Basket(new ArrayList<>(), inventory);
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        b.addProduct(bagel);
        b.addFilling((Bagel) b.getProducts().getFirst(), new Filling("FILB", 0.12, "Filling", "Bacon"));

        Assertions.assertEquals("FILB", ((Bagel) b.getProducts().getFirst()).getFillings().getFirst().getSku());
    }

    @Test
    public void removeItemNotInBasketShouldThrow() {
        Basket b = new Basket(new ArrayList<>(), inventory);

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.removeProduct("NotExistingProduct"));
    }

    @Test
    public void removeProductExistingInBasket() {
        Basket b = new Basket(new ArrayList<>(), inventory);
        b.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        b.removeProduct("BGLO");

        Assertions.assertTrue(b.getProducts().isEmpty());
    }

    @Test
    public void totalCostShouldBeZeroForEmptyBasket() {
        Basket b = new Basket(new ArrayList<>(), inventory);

        Assertions.assertEquals(0, b.getTotalCost());
    }

    @Test
    public void totalCostShouldAddUp() {
        Basket b = new Basket(new ArrayList<>(), inventory);
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
