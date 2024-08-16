package com.rms.models;

/**
 * Model class representing a menu item.
 */
public class MenuItem {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean available;

    public MenuItem() {}

    public MenuItem(int id, String name, String description, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "MenuItem{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               ", available=" + available +
               '}';
    }
}
