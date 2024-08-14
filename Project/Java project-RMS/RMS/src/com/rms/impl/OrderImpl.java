package com.rms.impl;

import com.rms.intf.OrderIntf;
import com.rms.models.Order;
import com.rms.repository.OrderRepository;

import java.util.List;

public class OrderImpl implements OrderIntf {
    private OrderRepository repository = new OrderRepository();
    
    @Override
    public void createOrder(Order order) {
        repository.add(order);
    }

    @Override
    public Order readOrder(int id) {
        return repository.get(id);
    }

    @Override
    public void updateOrder(Order order) {
        repository.update(order);
    }

    @Override
    public void deleteOrder(int id) {
        repository.remove(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.getAll();
    }
}
