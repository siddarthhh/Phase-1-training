package com.rms.service;

import com.rms.intf.UserIntf;
import com.rms.impl.UserImpl;
import com.rms.models.User;

import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Service class for managing users.
 * This class handles operations related to users such as creating, reading,
 * updating, deleting, and listing all users. It interacts with the data access layer
 * through the UserIntf interface, ensuring loose coupling.
 */
public class UserService {
    private final UserIntf userIntf;

    /**
     * Default constructor for UserService.
     * Initializes the userIntf with an instance of UserImpl.
     */
    public UserService() {
        this.userIntf = new UserImpl();
    }

    /**
     * Main method to manage users.
     * Provides a console-based interface for managing users.
     *
     * @param scanner Scanner object for user input.
     */
    public void manageUsers(Scanner scanner) {
        while (true) {
            System.out.println("User Management");
            System.out.println("1. Create User");
            System.out.println("2. Read User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. List All Users");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        createUser(scanner);
                        break;
                    case 2:
                        readUser(scanner);
                        break;
                    case 3:
                        updateUser(scanner);
                        break;
                    case 4:
                        deleteUser(scanner);
                        break;
                    case 5:
                        listAllUsers();
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

    private void createUser(Scanner scanner) {
        try {
            System.out.print("Enter User Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.print("Enter Role: ");
            String role = scanner.nextLine();
            
            User user = new User(0, name, email, password, role);
            userIntf.createUser(user);
            System.out.println("User Created.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void readUser(Scanner scanner) {
        try {
            System.out.print("Enter User ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            User user = userIntf.readUser(id);
            if (user != null) {
                System.out.println(user);
            } else {
                System.out.println("User not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void updateUser(Scanner scanner) {
        try {
            System.out.print("Enter User ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            User user = userIntf.readUser(id);
            if (user != null) {
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter New Password: ");
                String password = scanner.nextLine();
                System.out.print("Enter New Role: ");
                String role = scanner.nextLine();
                
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setRole(role);
                
                userIntf.updateUser(user);
                System.out.println("User Updated.");
            } else {
                System.out.println("User not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void deleteUser(Scanner scanner) {
        try {
            System.out.print("Enter User ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            userIntf.deleteUser(id);
            System.out.println("User Deleted.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void listAllUsers() {
        List<User> users = userIntf.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No Users found.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
