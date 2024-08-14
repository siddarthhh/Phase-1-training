package com.rms.service;

import com.rms.impl.ReservationImpl;
import com.rms.models.Reservation;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ReservationService {
    private ReservationImpl reservationImpl = new ReservationImpl();
    
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
        }
    }

    private void createReservation(Scanner scanner) {
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
        reservationImpl.createReservation(reservation);
        System.out.println("Reservation Created.");
    }

    private void readReservation(Scanner scanner) {
        System.out.print("Enter Reservation ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Reservation reservation = reservationImpl.readReservation(id);
        if (reservation != null) {
            System.out.println(reservation);
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private void updateReservation(Scanner scanner) {
        System.out.print("Enter Reservation ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Reservation reservation = reservationImpl.readReservation(id);
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
            
            reservationImpl.updateReservation(reservation);
            System.out.println("Reservation Updated.");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private void deleteReservation(Scanner scanner) {
        System.out.print("Enter Reservation ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        reservationImpl.deleteReservation(id);
        System.out.println("Reservation Deleted.");
    }

    private void listAllReservations() {
        List<Reservation> reservations = reservationImpl.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("No Reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
