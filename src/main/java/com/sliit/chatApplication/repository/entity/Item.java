package com.sliit.chatApplication.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
//
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
public class Item extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long itemId;
    String itemName;
    String itemCode;
    String description;
    long price;
//    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
//    List<CartItem> cartItems;


    public Item() {
    }

    public Item(String itemName, String itemCode, String description, long price) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.description = description;
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
}
