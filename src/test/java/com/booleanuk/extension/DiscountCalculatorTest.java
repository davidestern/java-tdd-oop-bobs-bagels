package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.BaseTest;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DiscountCalculatorTest extends BaseTest {

    @Test
    public void testMixedBagelsAndCoffeeDiscount() {
        BasketExtension be = new BasketExtension(new ArrayList<>(), inventory);
        be.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        be.addProduct(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        for (int i = 0; i < 12; i++)
            be.addProduct(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        for (int i = 0; i < 6; i++)
            be.addProduct(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        for (int i = 0; i < 3; i++)
            be.addProduct(new Coffee("COFB", 0.99, "Coffee", "Black"));

        Assertions.assertEquals(9.97, be.getTotalCost(), 0.01);
    }

    @Test
    public void testSixteenPlainBagelsDiscount() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 16; i++)
            products.add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));

        DiscountCalculator calculator = new DiscountCalculator(products);
        Assertions.assertEquals(5.55, calculator.calculateDiscountedPrice(), 0.01);
    }
}