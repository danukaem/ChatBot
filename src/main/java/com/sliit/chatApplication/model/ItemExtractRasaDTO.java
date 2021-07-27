package com.sliit.chatApplication.model;

public class ItemExtractRasaDTO extends SuperDTO {
    private int itemExtractId;
    private String itemCategory;
    private String ram;
    private String screen;
    private String brand;
    private String color;
    private String price;
    private String storage;
    private float userId;
    private String sessionId;


    public ItemExtractRasaDTO() {
    }

    public ItemExtractRasaDTO(int itemExtractId, String itemCategory, String ram, String screen, String brand, String color, String price, String storage, float userId, String sessionId) {
        this.itemExtractId = itemExtractId;
        this.itemCategory = itemCategory;
        this.ram = ram;
        this.screen = screen;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.storage = storage;
        this.userId = userId;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public float getUserId() {
        return userId;
    }

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public int getItemExtractId() {
        return itemExtractId;
    }

    public void setItemExtractId(int itemExtractId) {
        this.itemExtractId = itemExtractId;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "ItemExtractRasaDTO{" +
                "itemExtractId=" + itemExtractId +
                ", itemCategory='" + itemCategory + '\'' +
                ", ram='" + ram + '\'' +
                ", screen='" + screen + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", storage='" + storage + '\'' +
                ", userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
