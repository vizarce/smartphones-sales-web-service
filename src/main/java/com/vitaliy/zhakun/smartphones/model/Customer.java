package com.vitaliy.zhakun.smartphones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private double ballance;
    private boolean silverMember;
    private boolean goldMember;
    private ShippingAddress shippingAddress;

    public Customer() {}

    public Customer(Long id, String firstName, String lastName,
                    String email, double ballance, boolean silverMember,
                    boolean goldMember, ShippingAddress shippingAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = "vizarce@gmail.com"; //email;
        this.ballance = ballance;
        this.silverMember = silverMember;
        this.goldMember = goldMember;
        this.shippingAddress = shippingAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBallance() {
        return ballance;
    }

    public void setBallance(double ballance) {
        this.ballance = ballance;
    }

    public boolean isSilverMember() {
        return silverMember;
    }

    public void setSilverMember(boolean silverMember) {
        this.silverMember = silverMember;
    }

    public boolean isGoldMember() {
        return goldMember;
    }

    public void setGoldMember(boolean goldMember) {
        this.goldMember = goldMember;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}