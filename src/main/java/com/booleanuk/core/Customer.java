package com.booleanuk.core;

public class Customer {
    private Basket basket;

    public Customer(Basket basket) {
        setBasket(basket);
    }

    public Basket getBasket() {
        return basket;
    }

    private void setBasket(Basket basket) {
        this.basket = basket;
    }
}
