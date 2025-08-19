package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void productNotExistShouldReturnFalse() {
        Inventory i = new Inventory();

        Assertions.assertFalse(i.hasProduct("NotRealSku"));
    }

    @Test
    public void productExistShouldReturnTrue() {
        Inventory i = new Inventory();

        Assertions.assertFalse(i.hasProduct("BGLO"));
    }
}
