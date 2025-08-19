package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void productNotExistShouldReturnFalse() {
        Assertions.assertFalse(inventory.hasProduct("NotRealSku"));
    }

    @Test
    public void productExistShouldReturnTrue() {
        Assertions.assertTrue(inventory.hasProduct("BGLO"));
    }
}
