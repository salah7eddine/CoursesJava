package com.company.data;

import java.math.BigDecimal;
import java.util.Objects;

import static com.company.data.Rating.*;
import static java.math.RoundingMode.*;

public class Product {

    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    /*public void setId(final int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

   /* public void setName(final String name) {
        this.name = name;
    }*/

    public BigDecimal getPrice() {
        return price;
    }

   /* public void setPrice(final BigDecimal price) {
        //price = BigDecimal.ONE;
        this.price = price;
    }*/

    public BigDecimal  getDiscount() {
        // discount calculation logic will be added here

        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public Product applyRating(Rating newRating) {
        // method logic will be added here

        return new Product(this.id, this.name, this.price, newRating);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if(o instanceof Product) {
            Product product = (Product) o;
            return id == product.id && Objects.equals(name, product.name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
