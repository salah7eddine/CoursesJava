package com.company.data;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Product {

    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        //price = BigDecimal.ONE;
        this.price = price;
    }

    public BigDecimal  getDiscount() {
        // discount calculation logic will be added here

        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }


}
