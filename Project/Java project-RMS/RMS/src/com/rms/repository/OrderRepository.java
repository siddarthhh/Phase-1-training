package com.rms.repository;

import com.rms.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository for storing and managing Order entities.
 */
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    private int idCounter = 1;

    public void save(Order order) {
        order.setId(idCounter++);
        orders.add(order);
    }

    public Order findById(int id) {
        return orders.stream()
                     .filter(order -> order.getId() == id)
                     .findFirst()
                     .orElse(null);
    }

    public void update(Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == order.getId()) {
                orders.set(i, order);
                return;
            }
        }
    }

    public void delete(int id) {
        orders.removeIf(order -> order.getId() == id);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }
}
