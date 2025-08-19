package com.booleanuk.extension;

import com.booleanuk.core.Product;

import java.util.List;

public class DiscountCalculator {
    private final double SIX_FOR_249 = 2.49;
    private final double TWELVE_FOR_399 = 3.99;
    private final double COFFEE_BAGEL_125 = 1.25;
    private final double BGLO_PRICE = 0.49;
    private final double BGLP_PRICE = 0.39;
    private final double BGLE_PRICE = 0.49;
    private final double COFB_PRICE  = 0.99;

    List<Product> products;

    public DiscountCalculator(List<Product> products) {
        setProducts(products);
    }

    public double calculateDiscountedPrice() {
        // save all bagels and coffees
        // -> returned value of this method will be added for every bagel
        // -> therefore divide by number of bagels

        int countBGLO = 0;
        int countBGLP = 0;
        int countBGLE = 0;
        int countCOFB = 0;

        for (Product p : products) {
            switch (p.getSku()) {
                case "BGLO" -> countBGLO++;
                case "BGLP" -> countBGLP++;
                case "BGLE" -> countBGLE++;
                case "COFB" -> countCOFB++;
            }
        }

        int numOf12BGLP = countBGLP / 12;
        int numOf6BGLO = countBGLO / 6;
        int numOf6BGLP = (countBGLP % 12) / 6;
        int numOf6BGLE = countBGLE / 6;


        int numOfSingleBGLO = countBGLO % 6;
        int numOfSingleBGLP = countBGLP % 6;
        int numOfSingleBGLE = countBGLE % 6;

        int countSingleBagelsTotal = numOfSingleBGLO + numOfSingleBGLP + numOfSingleBGLE;
        int numOfCoffeeDeals = Math.min(countSingleBagelsTotal, countCOFB);

        double coffeeDealPrice = numOfCoffeeDeals * (COFFEE_BAGEL_125 - COFB_PRICE);

        for (int i = 0; i < numOfCoffeeDeals; i++) {
            if (numOfSingleBGLO > 0) numOfSingleBGLO--;
            else if (numOfSingleBGLE > 0) numOf6BGLE--;
            else if (numOfSingleBGLP > 0) numOf6BGLP--;
            else break;
        }

        double discountedPrice = numOf12BGLP * TWELVE_FOR_399 + numOf6BGLO * SIX_FOR_249 + numOf6BGLP * SIX_FOR_249 + numOf6BGLE * SIX_FOR_249;
        double singlesPrice = numOfSingleBGLO * BGLO_PRICE + numOfSingleBGLP * BGLP_PRICE + numOfSingleBGLE * BGLE_PRICE;

        return (coffeeDealPrice + discountedPrice + singlesPrice);
    }

    // Setter
    private void setProducts(List<Product> products) {
        this.products = products;
    }
}
