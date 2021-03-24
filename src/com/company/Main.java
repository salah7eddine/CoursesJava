package com.company;

import com.company.data.Drink;
import com.company.data.Food;
import com.company.data.Product;
import com.company.data.ProductManger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static com.company.data.Rating.*;

public class Main {

    public static void main(String[] args) {
        ProductManger pm = new ProductManger("en-GB");


        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), NOT_RATED);
        //pm.printProductReport(p1);
        //pm.printProductReport(101);
        pm.reviewProduct(101, FOUR_STAR, "Nice hot cup of tea");
        pm.reviewProduct(101, TWO_STAR, "Rather weak tea");
        pm.reviewProduct(101, FOUR_STAR, "Fine tea");
        pm.reviewProduct(101, FIVE_STAR, "Good tea");
        pm.reviewProduct(101, THREE_STAR, "Perfect tea");
        pm.reviewProduct(101, ONE_STAR, "Just add some sucre");
        pm.reviewProduct(101, THREE_STAR, "Just add some lemon");
        //pm.printProductReport(101);
        System.out.println("-----------------------------");
        //pm.changeLocale("zh-CN");
        pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), FOUR_STAR);
        pm.reviewProduct(102, FOUR_STAR, "Coffee wa ok");
        pm.reviewProduct(102, TWO_STAR, "where is the milk ?");
        pm.reviewProduct(102, FIVE_STAR, "It's perfect with tne spoons of sugar !");
        //pm.printProductReport(p2);

        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
        pm.printProducts(priceSorter.thenComparing(priceSorter));
        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());


    }
}
