package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShopManager {
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    // Операция: поиск товаров по производителю
    public List<Product> searchByProducer(String producerName) {
        return products.stream()
                .filter(p -> p.getProducer().getName().equalsIgnoreCase(producerName))
                .collect(Collectors.toList());
    }

    // Операция: фильтрация заказов по сумме
    public List<Order> filterOrdersBySum(double minSum) {
        return orders.stream()
                .filter(o -> o.getTotalSum() >= minSum)
                .collect(Collectors.toList());
    }
}