package com.rms.impl;

import com.rms.intf.OrderIntf;
import com.rms.models.Order;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of OrderIntf for managing orders.
 */
public class OrderImpl implements OrderIntf {
    private List<Order> orders = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void createOrder(Order order) {
        order.setId(idCounter++);
        orders.add(order);
    }

    @Override
    public Order readOrder(int id) {
        return orders.stream()
                     .filter(order -> order.getId() == id)
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public void updateOrder(Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == order.getId()) {
                orders.set(i, order);
                return;
            }
        }
    }

    @Override
    public void deleteOrder(int id) {
        orders.removeIf(order -> order.getId() == id);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
