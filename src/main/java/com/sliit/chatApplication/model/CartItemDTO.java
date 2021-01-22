package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.OrderDetails;


import java.util.List;


public class CartItemDTO extends SuperDTO {

    private long cartItemId;
    Item item;
    private long quantity;
    private OrderDetails orderDetails;

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

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "cartItemId=" + cartItemId +
                ", item=" + item +
                ", quantity=" + quantity +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
