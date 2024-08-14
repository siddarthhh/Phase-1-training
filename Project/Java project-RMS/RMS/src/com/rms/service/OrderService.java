package com.rms.service;

import com.rms.impl.OrderImpl;
import com.rms.models.Order;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private OrderImpl orderImpl = new OrderImpl();
    
    public void manageOrders(Scanner scanner) {
        while (true) {
            System.out.println("Order Management");
            System.out.println("1. Create Order");
            System.out.println("2. Read Order");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. List All Orders");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    createOrder(scanner);
                    break;
                case 2:
                    readOrder(scanner);
                    break;
                case 3:
                    updateOrder(scanner);
                    break;
                case 4:
                    deleteOrder(scanner);
                    break;
                case 5:
                    listAllOrders();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createOrder(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Order Date (YYYY-MM-DD): ");
        String dateString = scanner.next();
        Date orderDate = java.sql.Date.valueOf(dateString);
        System.out.print("Enter Total Amount: ");
        double totalAmount = scanner.nextDouble();
        System.out.print("Enter Table ID: ");
        int tableId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Order order = new Order(0, userId, orderDate, totalAmount, tableId);
        orderImpl.createOrder(order);
        System.out.println("Order Created.");
    }

    private void readOrder(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Order order = orderImpl.readOrder(id);
        if (order != null) {
            System.out.println(order);
        } else {
            System.out.println("Order not found.");
        }
    }

    private void updateOrder(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Order order = orderImpl.readOrder(id);
        if (order != null) {
            System.out.print("Enter New User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Enter New Order Date (YYYY-MM-DD): ");
            String dateString = scanner.next();
            Date orderDate = java.sql.Date.valueOf(dateString);
            System.out.print("Enter New Total Amount: ");
            double totalAmount = scanner.nextDouble();
            System.out.print("Enter New Table ID: ");
            int tableId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            order.setUserId(userId);
            order.setOrderDate(orderDate);
            order.setTotalAmount(totalAmount);
            order.setTableId(tableId);
            
            orderImpl.updateOrder(order);
            System.out.println("Order Updated.");
        } else {
            System.out.println("Order not found.");
        }
    }

    private void deleteOrder(Scanner scanner) {
        System.out.print("Enter Order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        orderImpl.deleteOrder(id);
        System.out.println("Order Deleted.");
    }

    private void listAllOrders() {
        List<Order> orders = orderImpl.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No Orders found.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}
