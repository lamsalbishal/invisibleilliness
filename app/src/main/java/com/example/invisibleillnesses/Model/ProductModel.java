package com.example.invisibleillnesses.Model;

public class ProductModel {

    private String id;
    private String name;
    private String price;
    private String designer;
    private String size;
    private String refundable;
    private String weekend;
    private String shortDescription;
    private String description;

    public ProductModel(String id, String name, String price, String designer, String size, String refundable, String weekend, String shortDescription, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.designer = designer;
        this.size = size;
        this.refundable = refundable;
        this.weekend = weekend;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRefundable() {
        return refundable;
    }

    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
