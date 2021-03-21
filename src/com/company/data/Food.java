package com.company.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product {

    private LocalDate bestBefore;

    public Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    @Override
    public BigDecimal getDiscount() {
        return bestBefore.isEqual(LocalDate.now()) ? super.getDiscount() : BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "Food{" +
                "bestBefore=" + bestBefore +
                '}';
    }
}
