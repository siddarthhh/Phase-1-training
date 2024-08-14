package com.rms.intf;

import com.rms.models.OrderDetail;

import java.util.List;

public interface OrderDetailIntf {
    void createOrderDetail(OrderDetail orderDetail);
    OrderDetail readOrderDetail(int id);
    void updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(int id);
    List<OrderDetail> getAllOrderDetails();
}
