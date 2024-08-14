package com.rms.impl;

import com.rms.intf.ReservationIntf;
import com.rms.models.Reservation;
import com.rms.repository.ReservationRepository;

import java.util.List;

public class ReservationImpl implements ReservationIntf {
    private ReservationRepository repository = new ReservationRepository();
    
    @Override
    public void createReservation(Reservation reservation) {
        repository.add(reservation);
    }

    @Override
    public Reservation readReservation(int id) {
        return repository.get(id);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        repository.update(reservation);
    }

    @Override
    public void deleteReservation(int id) {
        repository.remove(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return repository.getAll();
    }
}
