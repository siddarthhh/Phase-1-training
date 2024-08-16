package com.rms.service;

import com.rms.intf.OrderIntf;
import com.rms.impl.OrderImpl;
import com.rms.models.Order;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Service class for managing orders.
 * This class handles operations related to orders such as creating, reading,
 * updating, deleting, and listing all orders. It interacts with the data access layer
 * through the OrderIntf interface, ensuring loose coupling.
 */
public class OrderService {
    private final OrderIntf orderIntf;

    /**
     * Default constructor for OrderService.
     * Initializes the orderIntf with an instance of OrderImpl.
     */
    public OrderService() {
        this.orderIntf = new OrderImpl();
    }

    /**
     * Main method to manage orders.
     * Provides a console-based interface for managing orders.
     *
     * @param scanner Scanner object for user input.
     */
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
            
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    private void createOrder(Scanner scanner) {
        try {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Enter Order Date (YYYY-MM-DD): ");
            String dateString = scanner.next();
            Date orderDate = Date.valueOf(dateString);
            System.out.print("Enter Total Amount: ");
            double totalAmount = scanner.nextDouble();
            System.out.print("Enter Table ID: ");
            int tableId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            Order order = new Order(0, userId, orderDate, totalAmount, tableId);
            orderIntf.createOrder(order);
            System.out.println("Order Created.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void readOrder(Scanner scanner) {
        try {
            System.out.print("Enter Order ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Order order = orderIntf.readOrder(id);
            if (order != null) {
                System.out.println(order);
            } else {
                System.out.println("Order not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void updateOrder(Scanner scanner) {
        try {
            System.out.print("Enter Order ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            Order order = orderIntf.readOrder(id);
            if (order != null) {
                System.out.print("Enter New User ID: ");
                int userId = scanner.nextInt();
                System.out.print("Enter New Order Date (YYYY-MM-DD): ");
                String dateString = scanner.next();
                Date orderDate = Date.valueOf(dateString);
                System.out.print("Enter New Total Amount: ");
                double totalAmount = scanner.nextDouble();
                System.out.print("Enter New Table ID: ");
                int tableId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                order.setUserId(userId);
                order.setOrderDate(orderDate);
                order.setTotalAmount(totalAmount);
                order.setTableId(tableId);
                
                orderIntf.updateOrder(order);
                System.out.println("Order Updated.");
            } else {
                System.out.println("Order not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void deleteOrder(Scanner scanner) {
        try {
            System.out.print("Enter Order ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            orderIntf.deleteOrder(id);
            System.out.println("Order Deleted.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void listAllOrders() {
        List<Order> orders = orderIntf.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No Orders found.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}
