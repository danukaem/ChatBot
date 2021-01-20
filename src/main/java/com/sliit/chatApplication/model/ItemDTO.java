package com.sliit.chatApplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
public class ItemDTO extends SuperDTO {


    long itemId;
    String itemName;
    String itemCode;
    String Description;
    long price;

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
}
