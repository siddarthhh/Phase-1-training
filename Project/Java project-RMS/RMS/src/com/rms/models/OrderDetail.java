package com.rms.models;

/**
 * Model class representing order details.
 */
public class OrderDetail {
    private int id;
    private int orderId;
    private int menuItemId;
    private int quantity;
    private double price;

    public OrderDetail() {}

    public OrderDetail(int id, int orderId, int menuItemId, int quantity, double price) {
        this.id = id;
        this.orderId = orderId;
        this.menuItemId = menuItemId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getMenuItemId() { return menuItemId; }
    public void setMenuItemId(int menuItemId) { this.menuItemId = menuItemId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "OrderDetail{" +
               "id=" + id +
               ", orderId=" + orderId +
               ", menuItemId=" + menuItemId +
               ", quantity=" + quantity +
               ", price=" + price +
               '}';
    }
}
