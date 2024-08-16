package com.rms.impl;

import com.rms.intf.ReservationIntf;
import com.rms.models.Reservation;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of ReservationIntf for managing reservations.
 */
public class ReservationImpl implements ReservationIntf {
    private List<Reservation> reservations = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void createReservation(Reservation reservation) {
        reservation.setId(idCounter++);
        reservations.add(reservation);
    }

    @Override
    public Reservation readReservation(int id) {
        return reservations.stream()
                           .filter(reservation -> reservation.getId() == id)
                           .findFirst()
                           .orElse(null);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == reservation.getId()) {
                reservations.set(i, reservation);
                return;
            }
        }
    }

    @Override
    public void deleteReservation(int id) {
        reservations.removeIf(reservation -> reservation.getId() == id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }
}
