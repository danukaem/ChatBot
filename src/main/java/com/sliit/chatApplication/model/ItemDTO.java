package com.sliit.chatApplication.model;

public class ItemDTO extends SuperDTO {


    private long itemId;
    private String itemName;
    private String itemCode;
    private String description;
    private String imgSrc;
    private String category;
    private long price;
    private long discountPercentage;
    private String ram;
    private String screen;
    private String brand;
    private String color;
    private String storage;
    private String processor;

    public ItemDTO() {
    }


    public ItemDTO(long itemId, String itemName, String itemCode, String description, String imgSrc, String category, long price, long discountPercentage, String ram, String screen, String brand, String color, String storage, String processor) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.description = description;
        this.imgSrc = imgSrc;
        this.category = category;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.ram = ram;
        this.screen = screen;
        this.brand = brand;
        this.color = color;
        this.storage = storage;
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setCategory(String category) {
        this.category = category;
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



    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(long discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", ram='" + ram + '\'' +
                ", screen='" + screen + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", storage='" + storage + '\'' +
                ", processor='" + processor + '\'' +
                '}';
    }
}
