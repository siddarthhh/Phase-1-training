package com.rms.service;

import com.rms.intf.ReservationIntf;
import com.rms.impl.ReservationImpl;
import com.rms.models.Reservation;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Service class for managing reservations.
 * This class handles operations related to reservations such as creating, reading,
 * updating, deleting, and listing all reservations. It interacts with the data access layer
 * through the ReservationIntf interface, ensuring loose coupling.
 */
public class ReservationService {
    private final ReservationIntf reservationIntf;

    /**
     * Default constructor for ReservationService.
     * Initializes the reservationIntf with an instance of ReservationImpl.
     */
    public ReservationService() {
        this.reservationIntf = new ReservationImpl();
    }

    /**
     * Main method to manage reservations.
     * Provides a console-based interface for managing reservations.
     *
     * @param scanner Scanner object for user input.
     */
    public void manageReservations(Scanner scanner) {
        while (true) {
            System.out.println("Reservation Management");
            System.out.println("1. Create Reservation");
            System.out.println("2. Read Reservation");
            System.out.println("3. Update Reservation");
            System.out.println("4. Delete Reservation");
            System.out.println("5. List All Reservations");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        createReservation(scanner);
                        break;
                    case 2:
                        readReservation(scanner);
                        break;
                    case 3:
                        updateReservation(scanner);
                        break;
                    case 4:
                        deleteReservation(scanner);
                        break;
                    case 5:
                        listAllReservations();
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

    private void createReservation(Scanner scanner) {
        try {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Enter Reservation Date (YYYY-MM-DD): ");
            String dateString = scanner.next();
            Date reservationDate = Date.valueOf(dateString);
            System.out.print("Enter Number of People: ");
            int numberOfPeople = scanner.nextInt();
            System.out.print("Enter Table ID: ");
            int tableId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            Reservation reservation = new Reservation(0, userId, reservationDate, numberOfPeople, tableId);
            reservationIntf.createReservation(reservation);
            System.out.println("Reservation Created.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void readReservation(Scanner scanner) {
        try {
            System.out.print("Enter Reservation ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Reservation reservation = reservationIntf.readReservation(id);
            if (reservation != null) {
                System.out.println(reservation);
            } else {
                System.out.println("Reservation not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void updateReservation(Scanner scanner) {
        try {
            System.out.print("Enter Reservation ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            Reservation reservation = reservationIntf.readReservation(id);
            if (reservation != null) {
                System.out.print("Enter New User ID: ");
                int userId = scanner.nextInt();
                System.out.print("Enter New Reservation Date (YYYY-MM-DD): ");
                String dateString = scanner.next();
                Date reservationDate = Date.valueOf(dateString);
                System.out.print("Enter New Number of People: ");
                int numberOfPeople = scanner.nextInt();
                System.out.print("Enter New Table ID: ");
                int tableId = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                reservation.setUserId(userId);
                reservation.setReservationDate(reservationDate);
                reservation.setNumberOfPeople(numberOfPeople);
                reservation.setTableId(tableId);
                
                reservationIntf.updateReservation(reservation);
                System.out.println("Reservation Updated.");
            } else {
                System.out.println("Reservation not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct values.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void deleteReservation(Scanner scanner) {
        try {
            System.out.print("Enter Reservation ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            reservationIntf.deleteReservation(id);
            System.out.println("Reservation Deleted.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    private void listAllReservations() {
        List<Reservation> reservations = reservationIntf.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("No Reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
