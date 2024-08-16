package com.rms.models;

/**
 * Model class representing a restaurant table.
 */
public class RestaurantTable {
    private int id;
    private int tableNumber;
    private int capacity;
    private String locationDescription;
    private String status;

    public RestaurantTable() {}

    public RestaurantTable(int id, int tableNumber, int capacity, String locationDescription, String status) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.locationDescription = locationDescription;
        this.status = status;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTableNumber() { return tableNumber; }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getLocationDescription() { return locationDescription; }
    public void setLocationDescription(String locationDescription) { this.locationDescription = locationDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "RestaurantTable{" +
               "id=" + id +
               ", tableNumber=" + tableNumber +
               ", capacity=" + capacity +
               ", locationDescription='" + locationDescription + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}
