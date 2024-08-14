package com.rms.intf;

import com.rms.models.Order;

import java.util.List;

public interface OrderIntf {
    void createOrder(Order order);
    Order readOrder(int id);
    void updateOrder(Order order);
    void deleteOrder(int id);
    List<Order> getAllOrders();
}
