package com.sliit.chatApplication.model;

public class ItemDTO extends SuperDTO {


    private long itemId;
    private String itemName;
    private String itemCode;
    private String Description;
    private String imgSrc;
    private ItemCategory category;
    private long price;
    private long discountPercentage;

    public ItemDTO() {
    }

    public ItemDTO(long itemId, String itemName, String itemCode, String description, String imgSrc, ItemCategory category, long price, long discountPercentage) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCode = itemCode;
        Description = description;
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", Description='" + Description + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
