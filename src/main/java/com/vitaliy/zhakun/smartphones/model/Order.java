package com.vitaliy.zhakun.smartphones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "order")
public class Order {

    @Id
    private Long id;
    private Long saleId;
    private String orderIdenentificator;
    private Customer customer;
    private LocalDate saleDate;
    private LocalTime saleTime;
    private LocalDate despatchDate;
    private double actualPrice;
    private double discount;
    private double realPrice;

    public Order() {}

    public Order(Long id, Long saleId, String orderIdenentificator,
                 Customer customer, LocalDate saleDate, LocalTime saleTime,
                 LocalDate despatchDate, double actualPrice,
                 double discount, double realPrice) {
        this.id = id;
        this.saleId = saleId;
        this.orderIdenentificator = orderIdenentificator;
        this.customer = customer;
        this.saleDate = saleDate;
        this.saleTime = saleTime;
        this.despatchDate = despatchDate;
        this.actualPrice = actualPrice;
        this.discount = discount;
        this.realPrice = realPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public String getOrderIdenentificator() {
        return orderIdenentificator;
    }

    public void setOrderIdenentificator(String orderIdenentificator) {
        this.orderIdenentificator = orderIdenentificator;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public LocalTime getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(LocalTime saleTime) {
        this.saleTime = saleTime;
    }

    public LocalDate getDespatchDate() {
        return despatchDate;
    }

    public void setDespatchDate(LocalDate despatchDate) {
        this.despatchDate = despatchDate;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }
}
