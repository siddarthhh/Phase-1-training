package com.rms.service;

import com.rms.impl.OrderDetailImpl;
import com.rms.intf.OrderDetailIntf;
import com.rms.models.OrderDetail;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Service class for managing order details.
 * This class handles operations related to order details such as creating, reading,
 * updating, deleting, and listing all order details. It interacts with the data access layer
 * through the OrderDetailIntf interface, ensuring loose coupling.
 */
public class OrderDetailService {
    private final OrderDetailIntf orderDetailIntf;

    /**
     * Default constructor for OrderDetailService.
     * Initializes the orderDetailIntf with an instance of OrderDetailImpl.
     */
    public OrderDetailService() {
        this.orderDetailIntf = new OrderDetailImpl();
    }

    /**
     * Main method to manage order details.
     * Provides a console-based interface for managing order details.
     *
     * @param scanner Scanner object for user input.
     */
    public void manageOrderDetails(Scanner scanner) {
        while (true) {
            System.out.println("Order Detail Management");
            System.out.println("1. Create Order Detail");
            System.out.println("2. Read Order Detail");
            System.out.println("3. Update Order Detail");
            System.out.println("4. Delete Order Detail");
            System.out.println("5. List All Order Details");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        createOrderDetail(scanner);
                        break;
                    case 2:
                        readOrderDetail(scanner);
                        break;
                    case 3:
                        updateOrderDetail(scanner);
                        break;
                    case 4:
                        deleteOrderDetail(scanner);
                        break;
                    case 5:
                        listAllOrderDetails();
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

    private void createOrderDetail(Scanner scanner) {
        try {
            System.out.print("Enter Order ID: ");
            int orderId = scanner.nextInt();
            System.out.print("Enter Menu Item ID: ");
            int menuItemId = scanner.nextInt();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            OrderDetail orderDetail = new OrderDetail(0, orderId, menuItemId, quantity, price);
            orderDetailIntf.createOrderDetail(orderDetail);
            System.out.println("Order Detail Created.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void readOrderDetail(Scanner scanner) {
        try {
            System.out.print("Enter Order Detail ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            OrderDetail orderDetail = orderDetailIntf.readOrderDetail(id);
            if (orderDetail != null) {
                System.out.println(orderDetail);
            } else {
                System.out.println("Order Detail not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void updateOrderDetail(Scanner scanner) {
        try {
            System.out.print("Enter Order Detail ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            OrderDetail orderDetail = orderDetailIntf.readOrderDetail(id);
            if (orderDetail != null) {
                System.out.print("Enter New Order ID: ");
                int orderId = scanner.nextInt();
                System.out.print("Enter New Menu Item ID: ");
                int menuItemId = scanner.nextInt();
                System.out.print("Enter New Quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Enter New Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // consume newline

                orderDetail.setOrderId(orderId);
                orderDetail.setMenuItemId(menuItemId);
                orderDetail.setQuantity(quantity);
                orderDetail.setPrice(price);

                orderDetailIntf.updateOrderDetail(orderDetail);
                System.out.println("Order Detail Updated.");
            } else {
                System.out.println("Order Detail not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void deleteOrderDetail(Scanner scanner) {
        try {
            System.out.print("Enter Order Detail ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            orderDetailIntf.deleteOrderDetail(id);
            System.out.println("Order Detail Deleted.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void listAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailIntf.getAllOrderDetails();
        if (orderDetails.isEmpty()) {
            System.out.println("No Order Details found.");
        } else {
            for (OrderDetail orderDetail : orderDetails) {
                System.out.println(orderDetail);
            }
        }
    }
}
