package com.rms.service;

import com.rms.impl.OrderDetailImpl;
import com.rms.models.OrderDetail;

import java.util.List;
import java.util.Scanner;

public class OrderDetailService {
    private OrderDetailImpl orderDetailImpl = new OrderDetailImpl();
    
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
        }
    }

    private void createOrderDetail(Scanner scanner) {
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
        orderDetailImpl.createOrderDetail(orderDetail);
        System.out.println("Order Detail Created.");
    }

    private void readOrderDetail(Scanner scanner) {
        System.out.print("Enter Order Detail ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        OrderDetail orderDetail = orderDetailImpl.readOrderDetail(id);
        if (orderDetail != null) {
            System.out.println(orderDetail);
        } else {
            System.out.println("Order Detail not found.");
        }
    }

    private void updateOrderDetail(Scanner scanner) {
        System.out.print("Enter Order Detail ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        OrderDetail orderDetail = orderDetailImpl.readOrderDetail(id);
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
            
            orderDetailImpl.updateOrderDetail(orderDetail);
            System.out.println("Order Detail Updated.");
        } else {
            System.out.println("Order Detail not found.");
        }
    }

    private void deleteOrderDetail(Scanner scanner) {
        System.out.print("Enter Order Detail ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        orderDetailImpl.deleteOrderDetail(id);
        System.out.println("Order Detail Deleted.");
    }

    private void listAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailImpl.getAllOrderDetails();
        if (orderDetails.isEmpty()) {
            System.out.println("No Order Details found.");
        } else {
            for (OrderDetail orderDetail : orderDetails) {
                System.out.println(orderDetail);
            }
        }
    }
}
