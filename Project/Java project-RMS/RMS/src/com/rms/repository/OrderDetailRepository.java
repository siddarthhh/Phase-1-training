package com.rms.repository;

import com.rms.models.OrderDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDetailRepository {
    private Map<Integer, OrderDetail> orderDetailMap = new HashMap<>();
    private static int idCounter = 1;

    public void add(OrderDetail orderDetail) {
        orderDetail.setId(idCounter++);
        orderDetailMap.put(orderDetail.getId(), orderDetail);
    }

    public OrderDetail get(int id) {
        return orderDetailMap.get(id);
    }

    public void update(OrderDetail orderDetail) {
        orderDetailMap.put(orderDetail.getId(), orderDetail);
    }

    public void remove(int id) {
        orderDetailMap.remove(id);
    }

    public List<OrderDetail> getAll() {
        return new ArrayList<>(orderDetailMap.values());
    }
}
