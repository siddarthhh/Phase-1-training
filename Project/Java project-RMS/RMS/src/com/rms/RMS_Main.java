package com.rms;

import com.rms.service.*;

import java.util.Scanner;

public class RMS_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        MenuItemService menuItemService = new MenuItemService();
        OrderService orderService = new OrderService();
        OrderDetailService orderDetailService = new OrderDetailService();
        ReservationService reservationService = new ReservationService();
        RestaurantTableService restaurantTableService = new RestaurantTableService();
        
        while (true) {
            System.out.println("Restauran"
            		+ ""
            		+ ""
            		+ ""
            		+ ""
            		+ "t Management System");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Menu Items");
            System.out.println("3. Manage Orders");
            System.out.println("4. Manage Order Details");
            System.out.println("5. Manage Reservations");
            System.out.println("6. Manage Restaurant Tables");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    userService.manageUsers(scanner);
                    break;
                case 2:
                    menuItemService.manageMenuItems(scanner);
                    break;
                case 3:
                    orderService.manageOrders(scanner);
                    break;
                case 4:
                    orderDetailService.manageOrderDetails(scanner);
                    break;
                case 5:
                    reservationService.manageReservations(scanner);
                    break;
                case 6:
                    restaurantTableService.manageRestaurantTables(scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
