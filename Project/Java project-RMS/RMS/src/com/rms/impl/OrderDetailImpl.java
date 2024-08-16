package com.rms.impl;

import com.rms.intf.OrderDetailIntf;
import com.rms.models.OrderDetail;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of OrderDetailIntf for managing order details.
 */
public class OrderDetailImpl implements OrderDetailIntf {
    private List<OrderDetail> orderDetails = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void createOrderDetail(OrderDetail orderDetail) {
        orderDetail.setId(idCounter++);
        orderDetails.add(orderDetail);
    }

    @Override
    public OrderDetail readOrderDetail(int id) {
        return orderDetails.stream()
                           .filter(detail -> detail.getId() == id)
                           .findFirst()
                           .orElse(null);
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i).getId() == orderDetail.getId()) {
                orderDetails.set(i, orderDetail);
                return;
            }
        }
    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetails.removeIf(detail -> detail.getId() == id);
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return new ArrayList<>(orderDetails);
    }
}
