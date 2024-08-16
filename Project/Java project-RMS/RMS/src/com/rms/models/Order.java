package com.rms.models;

import java.util.Date;

/**
 * Model class representing an order.
 */
public class Order {
    private int id;
    private int userId;
    private Date orderDate;
    private double totalAmount;
    private int tableId;

    public Order() {}

    public Order(int id, int userId, Date orderDate, double totalAmount, int tableId) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.tableId = tableId;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public int getTableId() { return tableId; }
    public void setTableId(int tableId) { this.tableId = tableId; }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", userId=" + userId +
               ", orderDate=" + orderDate +
               ", totalAmount=" + totalAmount +
               ", tableId=" + tableId +
               '}';
    }
}
