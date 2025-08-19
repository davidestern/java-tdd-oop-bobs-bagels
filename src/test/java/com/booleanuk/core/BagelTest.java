package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest extends BaseTest {

    @Test
    public void addedBagelAndFillingPriceCorrect() {
        Bagel b = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        b.addFilling(new Filling("FILB", 0.12, "Filling", "Bacon"));

        Assertions.assertEquals(0.61, b.getTotalPrice());

        b.addFilling(new Filling("FILE", 0.12, "Filling", "Egg"));

        Assertions.assertEquals(0.73, b.getTotalPrice());
    }

}
