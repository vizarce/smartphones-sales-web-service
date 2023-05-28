package com.vitaliy.zhakun.smartphones.model;

public class ShippingAddress {

    private int buildingNo;
    private int appartmentsNo;
    private String street;
    private String city;
    private String country;
    private int postal;

    public ShippingAddress() {}

    public ShippingAddress(int buildingNo, int appartmentsNo,
                           String street, String city,
                           String country, int postal) {
        this.buildingNo = buildingNo;
        this.appartmentsNo = appartmentsNo;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postal = postal;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildinfNo) {
        this.buildingNo = buildinfNo;
    }

    public int getAppartmentsNo() {
        return appartmentsNo;
    }

    public void setAppartmentsNo(int appartmentsNo) {
        this.appartmentsNo = appartmentsNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }
}
