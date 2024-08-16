package com.rms.intf;

import com.rms.models.OrderDetail;

import java.util.List;

/**
 * Interface for OrderDetail data access operations.
 */
public interface OrderDetailIntf {
    void createOrderDetail(OrderDetail detail);
    OrderDetail readOrderDetail(int id);
    void updateOrderDetail(OrderDetail detail);
    void deleteOrderDetail(int id);
    List<OrderDetail> getAllOrderDetails();
}
