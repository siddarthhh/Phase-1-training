package com.rms.service;

import com.rms.impl.UserImpl;
import com.rms.models.User;

import java.util.List;
import java.util.Scanner;

public class UserService {
    private UserImpl userImpl = new UserImpl();
    
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
        }
    }

    private void createUser(Scanner scanner) {
        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();
        
        User user = new User(0, name, email, password, role);
        userImpl.createUser(user);
        System.out.println("User Created.");
    }

    private void readUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        User user = userImpl.readUser(id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        User user = userImpl.readUser(id);
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
            
            userImpl.updateUser(user);
            System.out.println("User Updated.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        userImpl.deleteUser(id);
        System.out.println("User Deleted.");
    }

    private void listAllUsers() {
        List<User> users = userImpl.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No Users found.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
