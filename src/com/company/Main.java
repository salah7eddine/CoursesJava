package com.company;

import com.company.data.Drink;
import com.company.data.Food;
import com.company.data.Product;
import com.company.data.ProductManger;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.company.data.Rating.*;

public class Main {

    public static void main(String[] args) {
        ProductManger pm = new ProductManger();
        Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), THREE_STAR);
        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), FOUR_STAR);
        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = pm.createProduct(105, "Cookie", BigDecimal.valueOf(3.99), TWO_STAR, LocalDate.now());
        Product p5 = p3.applyRating(THREE_STAR);
        Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), FIVE_STAR);
        Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), FIVE_STAR, LocalDate.now().plusDays(2));
        Product p8 = p4.applyRating(FIVE_STAR);
        Product p9 = p1.applyRating(TWO_STAR);

        //p3 = p3.applyRating(THREE_STAR);
//        p1.setId(101);
//        p1.setName("Tea");
//        p1.setPrice(BigDecimal.valueOf(1.99));


       /* System.out.println(p1.getId() +" "+p1.getName()+" "+p1.getPrice()+" "+p1.getDiscount()+" "+p1.getRating());
        System.out.println(p2.getId() +" "+p2.getName()+" "+p2.getPrice()+" "+p2.getDiscount()+" "+p2.getRating());
        System.out.println(p3.getId() +" "+p3.getName()+" "+p3.getPrice()+" "+p3.getDiscount()+" "+p3.getRating());
        System.out.println(p4.getId() +" "+p4.getName()+" "+p4.getPrice()+" "+p4.getDiscount()+" "+p4.getRating());
        System.out.println(p5.getId() +" "+p5.getName()+" "+p5.getPrice()+" "+p5.getDiscount()+" "+p5.getRating());*/

        /*if (p3 instanceof Food) {
            LocalDate bestBefore = ((Food) p3).getBestBefore();
            System.out.println(bestBefore);
        }*/

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p6.equals(p7));
        System.out.println(p8);
        System.out.println(p9);


        System.out.println(p3.getBestBefore());
        System.out.println(p1.getBestBefore());


    }
}
