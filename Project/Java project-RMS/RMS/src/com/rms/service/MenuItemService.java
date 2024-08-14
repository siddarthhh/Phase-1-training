package com.rms.service;

import com.rms.impl.MenuItemImpl;
import com.rms.models.MenuItem;

import java.util.List;
import java.util.Scanner;

public class MenuItemService {
    private MenuItemImpl menuItemImpl = new MenuItemImpl();
    
    public void manageMenuItems(Scanner scanner) {
        while (true) {
            System.out.println("Menu Item Management");
            System.out.println("1. Create Menu Item");
            System.out.println("2. Read Menu Item");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. List All Menu Items");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    createMenuItem(scanner);
                    break;
                case 2:
                    readMenuItem(scanner);
                    break;
                case 3:
                    updateMenuItem(scanner);
                    break;
                case 4:
                    deleteMenuItem(scanner);
                    break;
                case 5:
                    listAllMenuItems();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void createMenuItem(Scanner scanner) {
        System.out.print("Enter Menu Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Is Available (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine(); // consume newline
        
        MenuItem menuItem = new MenuItem(0, name, description, price, available);
        menuItemImpl.createMenuItem(menuItem);
        System.out.println("Menu Item Created.");
    }

    private void readMenuItem(Scanner scanner) {
        System.out.print("Enter Menu Item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        MenuItem menuItem = menuItemImpl.readMenuItem(id);
        if (menuItem != null) {
            System.out.println(menuItem);
        } else {
            System.out.println("Menu Item not found.");
        }
    }

    private void updateMenuItem(Scanner scanner) {
        System.out.print("Enter Menu Item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        MenuItem menuItem = menuItemImpl.readMenuItem(id);
        if (menuItem != null) {
            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter New Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Is Available (true/false): ");
            boolean available = scanner.nextBoolean();
            scanner.nextLine(); // consume newline
            
            menuItem.setName(name);
            menuItem.setDescription(description);
            menuItem.setPrice(price);
            menuItem.setAvailable(available);
            
            menuItemImpl.updateMenuItem(menuItem);
            System.out.println("Menu Item Updated.");
        } else {
            System.out.println("Menu Item not found.");
        }
    }

    private void deleteMenuItem(Scanner scanner) {
        System.out.print("Enter Menu Item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        menuItemImpl.deleteMenuItem(id);
        System.out.println("Menu Item Deleted.");
    }

    private void listAllMenuItems() {
        List<MenuItem> menuItems = menuItemImpl.getAllMenuItems();
        if (menuItems.isEmpty()) {
            System.out.println("No Menu Items found.");
        } else {
            for (MenuItem menuItem : menuItems) {
                System.out.println(menuItem);
            }
        }
    }
}
