package com.rms.impl;

import com.rms.intf.OrderDetailIntf;
import com.rms.models.OrderDetail;
import com.rms.repository.OrderDetailRepository;

import java.util.List;

public class OrderDetailImpl implements OrderDetailIntf {
    private OrderDetailRepository repository = new OrderDetailRepository();
    
    @Override
    public void createOrderDetail(OrderDetail orderDetail) {
        repository.add(orderDetail);
    }

    @Override
    public OrderDetail readOrderDetail(int id) {
        return repository.get(id);
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        repository.update(orderDetail);
    }

    @Override
    public void deleteOrderDetail(int id) {
        repository.remove(id);
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return repository.getAll();
    }
}
