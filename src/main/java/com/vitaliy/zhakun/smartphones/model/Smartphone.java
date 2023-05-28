package com.vitaliy.zhakun.smartphones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "smartphone")
public class Smartphone {

    @Id
    private Long id;
    private String brand;
    private String model;
    private String subModel;
    private String[] colors;
    private String chipset;
    private int processorGHz;
    private int romGb;
    private int ramGb;
    private int batteryMah;
    private int rearCameraMp;
    private int frontCameraMp;
    private String display;
    private double displaySizeInch;
    private String displayResolutionPxl;
    private String network;
    private String ports;
    private String[] connectivity;
    private double weightOunces;
    private double length;
    private double height;
    private double width;
    private String operatingSystem;
    private double originalPriceUsd;
    private double goldMembersDiscount;
    private double silverMembersDiscount;
    private double rating;
    private int quantity;

    public Smartphone() {}

    public Smartphone(Long id, String brand, String model, String subModel,
                      String[] colors, String chipset, int processorGHz,
                      int romGb, int ramGb, int batteryMah, int rearCameraMp,
                      int frontCameraMp, String display, double displaySizeInch,
                      String displayResolutionPxl, String network, String ports,
                      String[] connectivity, double weightOunces, double length,
                      double height, double width, String operatingSystem,
                      double originalPriceUsd, double goldMembersDiscount,
                      double silverMembersDiscount, double rating, int quantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.subModel = subModel;
        this.colors = colors;
        this.chipset = chipset;
        this.processorGHz = processorGHz;
        this.romGb = romGb;
        this.ramGb = ramGb;
        this.batteryMah = batteryMah;
        this.rearCameraMp = rearCameraMp;
        this.frontCameraMp = frontCameraMp;
        this.display = display;
        this.displaySizeInch = displaySizeInch;
        this.displayResolutionPxl = displayResolutionPxl;
        this.network = network;
        this.ports = ports;
        this.connectivity = connectivity;
        this.weightOunces = weightOunces;
        this.length = length;
        this.height = height;
        this.width = width;
        this.operatingSystem = operatingSystem;
        this.originalPriceUsd = originalPriceUsd;
        this.goldMembersDiscount = goldMembersDiscount;
        this.silverMembersDiscount = silverMembersDiscount;
        this.rating = rating;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSubModel() {
        return subModel;
    }

    public void setSubModel(String subModel) {
        this.subModel = subModel;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public int getProcessorGHz() {
        return processorGHz;
    }

    public void setProcessorGHz(int processorGHz) {
        this.processorGHz = processorGHz;
    }

    public int getRomGb() {
        return romGb;
    }

    public void setRomGb(int romGb) {
        this.romGb = romGb;
    }

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    public int getBatteryMah() {
        return batteryMah;
    }

    public void setBatteryMah(int batteryMah) {
        this.batteryMah = batteryMah;
    }

    public int getRearCameraMp() {
        return rearCameraMp;
    }

    public void setRearCameraMp(int rearCameraMp) {
        this.rearCameraMp = rearCameraMp;
    }

    public int getFrontCameraMp() {
        return frontCameraMp;
    }

    public void setFrontCameraMp(int frontCameraMp) {
        this.frontCameraMp = frontCameraMp;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public double getDisplaySizeInch() {
        return displaySizeInch;
    }

    public void setDisplaySizeInch(double displaySizeInch) {
        this.displaySizeInch = displaySizeInch;
    }

    public String getDisplayResolutionPxl() {
        return displayResolutionPxl;
    }

    public void setDisplayResolutionPxl(String displayResolutionPxl) {
        this.displayResolutionPxl = displayResolutionPxl;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String[] getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String[] connectivity) {
        this.connectivity = connectivity;
    }

    public double getWeightOunces() {
        return weightOunces;
    }

    public void setWeightOunces(double weightOunces) {
        this.weightOunces = weightOunces;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getOriginalPriceUsd() {
        return originalPriceUsd;
    }

    public void setOriginalPriceUsd(double originalPriceUsd) {
        this.originalPriceUsd = originalPriceUsd;
    }

    public double getGoldMembersDiscount() {
        return goldMembersDiscount;
    }

    public void setGoldMembersDiscount(double goldMembersDiscount) {
        this.goldMembersDiscount = goldMembersDiscount;
    }

    public double getSilverMembersDiscount() {
        return silverMembersDiscount;
    }

    public void setSilverMembersDiscount(double silverMembersDiscount) {
        this.silverMembersDiscount = silverMembersDiscount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
