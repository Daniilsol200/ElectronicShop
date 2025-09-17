package main.java;

public class Product {
    private int id;
    private String name;
    private double price;
    private Producer producer;

    public Product(int id, String name, double price, Producer producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public Producer getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Товар{id=" + id + ", название='" + name + "', цена=" + price + ", производитель=" + producer.getName() + "}";
    }
}