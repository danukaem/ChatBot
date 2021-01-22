package com.sliit.chatApplication.model;

public class ItemDTO extends SuperDTO {


    private long itemId;
    private String itemName;
    private String itemCode;
    private String Description;
    private long price;

    public ItemDTO() {
    }

    public ItemDTO(long itemId, String itemName, String itemCode, String description, long price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCode = itemCode;
        Description = description;
        this.price = price;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", Description='" + Description + '\'' +
                ", price=" + price +
                '}';
    }
}
