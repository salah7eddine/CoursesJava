package com.company.data;

import java.math.BigDecimal;

public class Drink extends Product {

   /* public Drink() {
        super();
    }*/

    public Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }
}
