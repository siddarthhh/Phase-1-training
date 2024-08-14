package com.rms.repository;

import com.rms.models.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationRepository {
    private Map<Integer, Reservation> reservationMap = new HashMap<>();
    private static int idCounter = 1;

    public void add(Reservation reservation) {
        reservation.setId(idCounter++);
        reservationMap.put(reservation.getId(), reservation);
    }

    public Reservation get(int id) {
        return reservationMap.get(id);
    }

    public void update(Reservation reservation) {
        reservationMap.put(reservation.getId(), reservation);
    }

    public void remove(int id) {
        reservationMap.remove(id);
    }

    public List<Reservation> getAll() {
        return new ArrayList<>(reservationMap.values());
    }
}
