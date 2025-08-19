package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testGetPriceForExistingProduct() {
        Coffee c = new Coffee("COFB", 0.99, "Coffee", "Black");

        Assertions.assertEquals(0.99, c.getPrice());
    }

    @Test
    public void testGetNameForExistingProduct() {
        Coffee c = new Coffee("COFB", 0.99, "Coffee", "Black");

        Assertions.assertEquals("Coffee", c.getName());
    }
}
