package com.rms.service;

import com.rms.impl.RestaurantTableImpl;
import com.rms.models.RestaurantTable;

import java.util.List;
import java.util.Scanner;

public class RestaurantTableService {
    private RestaurantTableImpl restaurantTableImpl = new RestaurantTableImpl();
    
    public void manageRestaurantTables(Scanner scanner) {
        while (true) {
            System.out.println("Restaurant Table Management");
            System.out.println("1. Create Restaurant Table");
            System.out.println("2. Read Restaurant Table");
            System.out.println("3. Update Restaurant Table");
            System.out.println("4. Delete Restaurant Table");
            System.out.println("5. List All Restaurant Tables");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    createRestaurantTable(scanner);
                    break;
                case 2:
                    readRestaurantTable(scanner);
                    break;
                case 3:
                    updateRestaurantTable(scanner);
                    break;
                case 4:
                    deleteRestaurantTable(scanner);
                    break;
                case 5:
                    listAllRestaurantTables();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createRestaurantTable(Scanner scanner) {
        System.out.print("Enter Table Number: ");
        int tableNumber = scanner.nextInt();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Location Description: ");
        String locationDescription = scanner.nextLine();
        System.out.print("Enter Status (Available/Occupied): ");
        String status = scanner.nextLine();
        
        RestaurantTable table = new RestaurantTable(0, tableNumber, capacity, locationDescription, status);
        restaurantTableImpl.createRestaurantTable(table);
        System.out.println("Restaurant Table Created.");
    }

    private void readRestaurantTable(Scanner scanner) {
        System.out.print("Enter Table ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        RestaurantTable table = restaurantTableImpl.readRestaurantTable(id);
        if (table != null) {
            System.out.println(table);
        } else {
            System.out.println("Restaurant Table not found.");
        }
    }

    private void updateRestaurantTable(Scanner scanner) {
        System.out.print("Enter Table ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        RestaurantTable table = restaurantTableImpl.readRestaurantTable(id);
        if (table != null) {
            System.out.print("Enter New Table Number: ");
            int tableNumber = scanner.nextInt();
            System.out.print("Enter New Capacity: ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter New Location Description: ");
            String locationDescription = scanner.nextLine();
            System.out.print("Enter New Status (Available/Occupied): ");
            String status = scanner.nextLine();
            
            table.setTableNumber(tableNumber);
            table.setCapacity(capacity);
            table.setLocationDescription(locationDescription);
            table.setStatus(status);
            
            restaurantTableImpl.updateRestaurantTable(table);
            System.out.println("Restaurant Table Updated.");
        } else {
            System.out.println("Restaurant Table not found.");
        }
    }

    private void deleteRestaurantTable(Scanner scanner) {
        System.out.print("Enter Table ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        restaurantTableImpl.deleteRestaurantTable(id);
        System.out.println("Restaurant Table Deleted.");
    }

    private void listAllRestaurantTables() {
        List<RestaurantTable> tables = restaurantTableImpl.getAllRestaurantTables();
        if (tables.isEmpty()) {
            System.out.println("No Restaurant Tables found.");
        } else {
            for (RestaurantTable table : tables) {
                System.out.println(table);
            }
        }
    }
}
