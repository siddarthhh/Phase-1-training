package com.rms.repository;

import com.rms.models.Reservation;

import java.util.ArrayList;
import java.util.List;


/**
 * Repository for storing and managing Reservation entities.
 */
public class ReservationRepository {
    private List<Reservation> reservations = new ArrayList<>();
    private int idCounter = 1;

    public void save(Reservation reservation) {
        reservation.setId(idCounter++);
        reservations.add(reservation);
    }

    public Reservation findById(int id) {
        return reservations.stream()
                           .filter(reservation -> reservation.getId() == id)
                           .findFirst()
                           .orElse(null);
    }

    public void update(Reservation reservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == reservation.getId()) {
                reservations.set(i, reservation);
                return;
            }
        }
    }

    public void delete(int id) {
        reservations.removeIf(reservation -> reservation.getId() == id);
    }

    public List<Reservation> findAll() {
        return new ArrayList<>(reservations);
    }
}
