package JavaSem6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " | Category: " + category + " | Price: $" + price;
    }
}

public class Project6_3 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1000),
                new Product("Phone", "Electronics", 800),
                new Product("Headphones", "Electronics", 150),
                new Product("Shirt", "Clothing", 40),
                new Product("Jeans", "Clothing", 60),
                new Product("Sofa", "Furniture", 700),
                new Product("Table", "Furniture", 250));

        // 1. Grouping products by category
        System.out.println("\nProducts grouped by category:");
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        groupedByCategory.forEach((category, productList) -> {
            System.out.println("\nCategory: " + category);
            productList.forEach(System.out::println);
        });

        // 2. Finding the most expensive product in each category
        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));

        mostExpensiveByCategory
                .forEach((category, product) -> System.out.println(category + ": " + product.orElse(null)));

        // 3. Calculating the average price of all products
        double avgPrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0);

        System.out.println("\nAverage price of all products: $" + avgPrice);
    }
}
