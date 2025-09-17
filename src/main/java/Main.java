package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopManager shop = new ShopManager();

        // Пример данных
        Producer apple = new Producer(1, "Apple");
        Producer samsung = new Producer(2, "Samsung");
        shop.addProduct(new Product(1, "iPhone 13", 999.99, apple));
        shop.addProduct(new Product(2, "Galaxy S21", 799.99, samsung));
        shop.addProduct(new Product(3, "MacBook Pro", 1999.99, apple));

        // Пример заказов
        List<Product> order1Products = Arrays.asList(shop.searchByProducer("Apple").get(0), shop.searchByProducer("Samsung").get(0));
        shop.addOrder(new Order(1, order1Products));
        List<Product> order2Products = Arrays.asList(shop.searchByProducer("Apple").get(1));
        shop.addOrder(new Order(2, order2Products));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню магазина электроники:");
            System.out.println("1. Поиск товаров по производителю");
            System.out.println("2. Фильтрация заказов по минимальной сумме");
            System.out.println("3. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (choice == 1) {
                System.out.print("Введите название производителя: ");
                String producer = scanner.nextLine();
                List<Product> results = shop.searchByProducer(producer);
                if (results.isEmpty()) {
                    System.out.println("Товары не найдены.");
                } else {
                    System.out.println("Найденные товары: " + results);
                }
            } else if (choice == 2) {
                System.out.print("Введите минимальную сумму: ");
                double minSum = scanner.nextDouble();
                List<Order> results = shop.filterOrdersBySum(minSum);
                if (results.isEmpty()) {
                    System.out.println("Заказы не найдены.");
                } else {
                    System.out.println("Отфильтрованные заказы: " + results);
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Неверная опция!");
            }
        }
        scanner.close();
    }
}