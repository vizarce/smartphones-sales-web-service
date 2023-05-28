package com.vitaliy.zhakun.smartphones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sale")
public class Sale {

    @Id
    private Long id;
    private Smartphone smartphone;
    private Manager manager;
    private int quantity;
    private double initialPrice;
    private double discount;
    private double finalPrice;
    private Customer customer;
    private Order order;

    public Sale() {}

    public Sale(Long id, Smartphone smartphone,
                Manager manager, int quantity,
                double initialPrice, double discount,
                double finalPrice, Customer customer,
                Order order) {
        this.id = id;
        this.smartphone = smartphone;
        this.manager = manager;
        this.quantity = quantity;
        this.initialPrice = initialPrice;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.customer = customer;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
