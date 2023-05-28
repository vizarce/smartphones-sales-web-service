package com.vitaliy.zhakun.smartphones.controller;

import com.vitaliy.zhakun.smartphones.model.Order;
import com.vitaliy.zhakun.smartphones.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderConroller {

    private final OrderService orderService;

    @Autowired
    public OrderConroller(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/update")
    public Order updateOrder(@RequestBody Order order, @PathVariable("id") Long id) {
        return orderService.updateOrder(order, id);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Order> deleteOrderById(@PathVariable("id") Long id) {
        Order deletedOrder = orderService.getOrderById(id);
        orderService.deleteOrderById(id);
        return new ResponseEntity<Order>(deletedOrder, HttpStatus.OK);
    }
}
