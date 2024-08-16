package com.rms.service;

import com.rms.impl.MenuItemImpl;
import com.rms.intf.MenuItemIntf;
import com.rms.models.MenuItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Service class for managing menu items.
 * This class handles the operations related to menu items such as creating, reading,
 * updating, deleting, and listing all menu items. It interacts with the data access layer
 * through the MenuItemIntf interface, ensuring loose coupling.
 */
public class MenuItemService {
    private final MenuItemIntf menuItemIntf;

    /**
     * Default constructor for MenuItemService.
     * Initializes the menuItemIntf with an instance of MenuItemImpl.
     */
    public MenuItemService() {
        this.menuItemIntf = new MenuItemImpl();
    }

    /**
     * Main method to manage menu items.
     * Provides a console-based interface for managing menu items.
     *
     * @param scanner Scanner object for user input.
     */
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

            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    private void createMenuItem(Scanner scanner) {
        try {
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
            menuItemIntf.createMenuItem(menuItem);
            System.out.println("Menu Item Created.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void readMenuItem(Scanner scanner) {
        try {
            System.out.print("Enter Menu Item ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            MenuItem menuItem = menuItemIntf.readMenuItem(id);
            if (menuItem != null) {
                System.out.println(menuItem);
            } else {
                System.out.println("Menu Item not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void updateMenuItem(Scanner scanner) {
        try {
            System.out.print("Enter Menu Item ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            MenuItem menuItem = menuItemIntf.readMenuItem(id);
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

                menuItemIntf.updateMenuItem(menuItem);
                System.out.println("Menu Item Updated.");
            } else {
                System.out.println("Menu Item not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void deleteMenuItem(Scanner scanner) {
        try {
            System.out.print("Enter Menu Item ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            menuItemIntf.deleteMenuItem(id);
            System.out.println("Menu Item Deleted.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void listAllMenuItems() {
        List<MenuItem> menuItems = menuItemIntf.getAllMenuItems();
        if (menuItems.isEmpty()) {
            System.out.println("No Menu Items found.");
        } else {
            for (MenuItem menuItem : menuItems) {
                System.out.println(menuItem);
            }
        }
    }
}
