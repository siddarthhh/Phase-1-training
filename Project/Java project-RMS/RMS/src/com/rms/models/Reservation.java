package com.rms.models;

import java.util.Date;

public class Reservation {
    private int id;
    private int userId;
    private Date reservationDate;
    private int numberOfPeople;
    private int tableId;

    // Default constructor
    public Reservation() {}

    // Constructor with all fields
    public Reservation(int id, int userId, Date reservationDate, int numberOfPeople, int tableId) {
        this.id = id;
        this.userId = userId;
        this.reservationDate = reservationDate;
        this.numberOfPeople = numberOfPeople;
        this.tableId = tableId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userId=" + userId +
                ", reservationDate=" + reservationDate +
                ", numberOfPeople=" + numberOfPeople +
                ", tableId=" + tableId +
                '}';
    }
}
