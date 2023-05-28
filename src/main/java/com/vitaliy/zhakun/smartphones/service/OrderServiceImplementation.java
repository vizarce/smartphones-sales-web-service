package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Order;
import com.vitaliy.zhakun.smartphones.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty())
            throw new IllegalStateException("Order with Id = " + id + " does not exist.");
        return optionalOrder.get();
    }

    @Override
    public Order updateOrder(Order order, Long id) {
        order.setId(id);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty())
            throw new IllegalStateException("Order with Id = " + id + " does not exist.");
        else
            orderRepository.deleteById(id);
    }

    private Long nextOrderId() {
        Long orderId;
        long orderIdsCount = orderRepository.count();
        if (orderIdsCount == 0) {
            orderId = 1L;
        } else {
            //Collections.sort(orderIds);
            //Collections.reverse(orderIds);
            orderId = orderIdsCount + 1;
        }
        return orderId;
    }
}
