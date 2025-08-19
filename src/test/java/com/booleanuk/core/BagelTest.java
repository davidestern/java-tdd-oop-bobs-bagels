package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BagelTest {

    @Test
    public void addFillingNotExistingShouldThrow() {
        Bagel b = new Bagel("BGLO", 0.49, "Bagel", "Onion");

        Assertions.assertThrows(IllegalArgumentException.class, () -> b.addFilling(new Filling("Not existing filling", 0, " ", " ")));
    }

    @Test
    public void addExistingFilling() {
        Bagel b = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        b.addFilling(new Filling("FILB", 0.12, "Filling", "Bacon"));

        Assertions.assertEquals("Filling", b.getFillings().getFirst().getName());
    }

    @Test
    public void addedBagelAndFillingPriceCorrect() {
        Bagel b = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        b.addFilling(new Filling("FILB", 0.12, "Filling", "Bacon"));

        Assertions.assertEquals(0.61, b.getPrice());

        b.addFilling(new Filling("FILE", 0.12, "Filling", "Egg"));

        Assertions.assertEquals(0.73, b.getPrice());
    }

}
