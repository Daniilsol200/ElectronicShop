package main.java;

import java.util.List;

public class Order {
    private int id;
    private List<Product> products;
    private double totalSum;

    public Order(int id, List<Product> products) {
        this.id = id;
        this.products = products;
        this.totalSum = products.stream().mapToDouble(Product::getPrice).sum();
    }

    public double getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return "Заказ{id=" + id + ", товары=" + products.size() + ", общая сумма=" + totalSum + "}";
    }
}