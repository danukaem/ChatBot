package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class CartItemDTO extends SuperDTO {

    long cartItemId;
    Item item;
    long quantity;
    OrderDetails orderDetails;

    public CartItemDTO() {
    }

    public CartItemDTO(long cartItemId, Item item, long quantity, OrderDetails orderDetails) {
        this.cartItemId = cartItemId;
        this.item = item;
        this.quantity = quantity;
        this.orderDetails = orderDetails;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
