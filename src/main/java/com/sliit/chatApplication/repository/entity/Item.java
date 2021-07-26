package com.sliit.chatApplication.repository.entity;


import com.sliit.chatApplication.model.ItemCategory;

import javax.persistence.*;

@Entity
public class Item extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String itemName;
    private String itemCode;
    private String description;
    private String imgSrc;
    private ItemCategory category;
    private long price;
    private long discountPercentage;

    public Item() {
    }

    public Item(String itemName, String itemCode, String description, String imgSrc, ItemCategory category, long price, long discountPercentage) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.description = description;
        this.imgSrc = imgSrc;
        this.category = category;
        this.price = price;
        this.discountPercentage = discountPercentage;
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
