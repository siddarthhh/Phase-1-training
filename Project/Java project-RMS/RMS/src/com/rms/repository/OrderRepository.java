package com.rms.repository;

import com.rms.models.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private Map<Integer, Order> orderMap = new HashMap<>();
    private static int idCounter = 1;

    public void add(Order order) {
        order.setId(idCounter++);
        orderMap.put(order.getId(), order);
    }

    public Order get(int id) {
        return orderMap.get(id);
    }

    public void update(Order order) {
        orderMap.put(order.getId(), order);
    }

    public void remove(int id) {
        orderMap.remove(id);
    }

    public List<Order> getAll() {
        return new ArrayList<>(orderMap.values());
    }
}
