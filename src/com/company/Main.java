package com.company;

import com.company.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.company.data.Rating.*;

public class Main {

    public static void main(String[] args) {
        ProductManger pm = ProductManger.getInstance(); 

        AtomicInteger clinetCount = new AtomicInteger();

        Callable<String> client = () -> {

            String clientId = "Client " + clinetCount.incrementAndGet();
            String threadName = Thread.currentThread().getName();
            int productId = ThreadLocalRandom.current().nextInt(63) + 101;
            String languageTag = ProductManger
                    .getSupportedLocales()
                    .stream()
                    .skip(ThreadLocalRandom.current()
                            .nextInt(4))
                    .findFirst()
                    .get();
            StringBuilder log = new StringBuilder();
            log.append(clientId +""+threadName+"\n-\tstart of log\t-\n");
            log.append(pm.getDiscounts(languageTag)
                    .entrySet()
                    .stream()
                    .map(entry -> entry.getKey() +"\t"+entry.getValue())
                    .collect(Collectors.joining("\n")));

            Product product = pm.reviewProduct(productId, FOUR_STAR, "Yet another review");
            log.append(product != null ? "\nProduct " + productId+" reviewed\n" : "\nProduct " + productId+" not reviewed\n");
            pm.printProductReport(productId, languageTag, clientId);
          log.append("\n-\tend of log\t-\n");

            return log.toString();
        };

        List<Callable<String>> clients = Stream.generate(() -> client).limit(5).collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> results = executorService.invokeAll(clients);
            executorService.shutdown();
            results.stream().forEach(result -> {
                try {
                    System.out.println(result.get());
                } catch (InterruptedException | ExecutionException e) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error retrieving client log", e);
                }
            });
        } catch (InterruptedException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error invoking clients", e);
        }

        //new ProductManger();
       /* pm.printProductReport(101, "en-GB");*/
       /* pm.printProductReport(102, "ru-RU");*/

       /* pm.createProduct(164, "Kombucha", BigDecimal.valueOf(1.99), NOT_RATED);
        pm.reviewProduct(164, TWO_STAR, "Looks like tea but is it ?");
        pm.reviewProduct(164, FOUR_STAR, "Fine tea");
        pm.reviewProduct(164, FOUR_STAR, "This is not tea");
        pm.reviewProduct(164, FIVE_STAR, "Perfect!");
        pm.printProductReport(164);*/
        //pm.dumpData();
        //pm.restoreData();
        //pm.printProductReport(101);
        //pm.printProductReport(164);
        /*
            pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), NOT_RATED);
            pm.printProductReport(101);
        */

        // pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
        //pm.parseProduct("D,101,Tea,1.99,0,2019-09-49");
        // pm.parseProduct("D,101,Tea,1.99,0,0");
        //pm.printProductReport(101);


        //pm.parseProduct("D,103,Tea,1.99,0,2019-09-49");
        //pm.printProductReport(103);

        //pm.parseReview("101,4,Nice hot cup of tea");
        //pm.parseReview("101,2,Rather weak tea");
        //pm.parseReview("101,4,Fine tea");
        //pm.parseReview("101,4,Good tea");
        //pm.parseReview("101,5,Perfect tea");
        //pm.parseReview("101,3,just add some lemon");
        //pm.printProductReport(101);

      /*  pm.printProductReport(101);
        pm.printProductReport(101);
        pm.reviewProduct(101, FOUR_STAR, "Nice hot cup of tea");
        pm.reviewProduct(101, TWO_STAR, "Rather weak tea");
        pm.reviewProduct(101, FOUR_STAR, "Fine tea");
        pm.reviewProduct(101, FIVE_STAR, "Good tea");
        pm.reviewProduct(101, THREE_STAR, "Perfect tea");
        pm.reviewProduct(101, ONE_STAR, "Just add some sucre");
        pm.reviewProduct(101, THREE_STAR, "Just add some lemon");
        pm.printProductReport(101);
        System.out.println("-----------------------------");
        pm.changeLocale("zh-CN");*/
        /*Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), FOUR_STAR);
        p2 = pm.reviewProduct(p2, FOUR_STAR, "Coffee wa ok");
        p2 = pm.reviewProduct(p2, TWO_STAR, "where is the milk ?");
        p2 = pm.reviewProduct(p2, FIVE_STAR, "It's perfect with tne spoons of sugar !");
        pm.printProductReport(p2);*/

        //pm.printProducts(p->p.getPrice().floatValue() < 2, (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());

        // p11 is p2
       /* Comparator<Product> ratingSorter = (p1, p11) -> p11.getRating().ordinal() - p1.getRating().ordinal();
        Comparator<Product> priceSorter = (p1, p11) -> p11.getPrice().compareTo(p1.getPrice());
        pm.printProducts(p -> p.getPrice().floatValue() < 2, (p1, p11) -> p11.getRating().ordinal() - p1.getRating().ordinal());

        pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating +"\t"+ discount));*/


    }
}
