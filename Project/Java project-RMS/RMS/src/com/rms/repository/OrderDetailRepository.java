package com.rms.repository;

import com.rms.models.OrderDetail;

import java.util.ArrayList;
import java.util.List;


/**
 * Repository for storing and managing OrderDetail entities.
 */
public class OrderDetailRepository {
    private List<OrderDetail> orderDetails = new ArrayList<>();
    private int idCounter = 1;

    public void save(OrderDetail orderDetail) {
        orderDetail.setId(idCounter++);
        orderDetails.add(orderDetail);
    }

    public OrderDetail findById(int id) {
        return orderDetails.stream()
                           .filter(detail -> detail.getId() == id)
                           .findFirst()
                           .orElse(null);
    }

    public void update(OrderDetail orderDetail) {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i).getId() == orderDetail.getId()) {
                orderDetails.set(i, orderDetail);
                return;
            }
        }
    }

    public void delete(int id) {
        orderDetails.removeIf(detail -> detail.getId() == id);
    }

    public List<OrderDetail> findAll() {
        return new ArrayList<>(orderDetails);
    }
}
