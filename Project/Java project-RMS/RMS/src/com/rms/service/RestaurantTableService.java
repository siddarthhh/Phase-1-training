package com.rms.service;

import com.rms.intf.RestaurantTableIntf;
import com.rms.impl.RestaurantTableImpl;
import com.rms.models.RestaurantTable;

import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Service class for managing restaurant tables.
 * This class handles operations related to restaurant tables such as creating, reading,
 * updating, deleting, and listing all tables. It interacts with the data access layer
 * through the RestaurantTableIntf interface, ensuring loose coupling.
 */
public class RestaurantTableService {
    private final RestaurantTableIntf restaurantTableIntf;

    /**
     * Default constructor for RestaurantTableService.
     * Initializes the restaurantTableIntf with an instance of RestaurantTableImpl.
     */
    public RestaurantTableService() {
        this.restaurantTableIntf = new RestaurantTableImpl();
    }

    /**
     * Main method to manage restaurant tables.
     * Provides a console-based interface for managing restaurant tables.
     *
     * @param scanner Scanner object for user input.
     */
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
            
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    private void createRestaurantTable(Scanner scanner) {
        try {
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
            restaurantTableIntf.createRestaurantTable(table);
            System.out.println("Restaurant Table Created.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void readRestaurantTable(Scanner scanner) {
        try {
            System.out.print("Enter Table ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            RestaurantTable table = restaurantTableIntf.readRestaurantTable(id);
            if (table != null) {
                System.out.println(table);
            } else {
                System.out.println("Restaurant Table not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void updateRestaurantTable(Scanner scanner) {
        try {
            System.out.print("Enter Table ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            RestaurantTable table = restaurantTableIntf.readRestaurantTable(id);
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
                
                restaurantTableIntf.updateRestaurantTable(table);
                System.out.println("Restaurant Table Updated.");
            } else {
                System.out.println("Restaurant Table not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void deleteRestaurantTable(Scanner scanner) {
        try {
            System.out.print("Enter Table ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            restaurantTableIntf.deleteRestaurantTable(id);
            System.out.println("Restaurant Table Deleted.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void listAllRestaurantTables() {
        List<RestaurantTable> tables = restaurantTableIntf.getAllRestaurantTables();
        if (tables.isEmpty()) {
            System.out.println("No Restaurant Tables found.");
        } else {
            for (RestaurantTable table : tables) {
                System.out.println(table);
            }
        }
    }
}
