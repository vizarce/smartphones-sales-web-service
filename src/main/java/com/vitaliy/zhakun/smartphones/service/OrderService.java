package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Manager;
import com.vitaliy.zhakun.smartphones.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrder(Order order, Long id);

    void deleteOrderById(Long id);
}
