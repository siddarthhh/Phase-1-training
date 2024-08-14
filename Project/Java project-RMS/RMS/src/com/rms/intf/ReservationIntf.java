package com.rms.intf;

import com.rms.models.Reservation;

import java.util.List;

public interface ReservationIntf {
    void createReservation(Reservation reservation);
    Reservation readReservation(int id);
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);
    List<Reservation> getAllReservations();
}
