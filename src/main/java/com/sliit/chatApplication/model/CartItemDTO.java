package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.OrderDetails;


import java.util.List;


public class CartItemDTO extends SuperDTO {

    private long cartItemId;
    private List<Item> items;
    private long quantity;
    private OrderDetails orderDetails;

    public CartItemDTO() {
    }

    public CartItemDTO(long cartItemId, List<Item> items, long quantity, OrderDetails orderDetails) {
        this.cartItemId = cartItemId;
        this.items = items;
        this.quantity = quantity;
        this.orderDetails = orderDetails;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
                ", items=" + items +
                ", quantity=" + quantity +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
