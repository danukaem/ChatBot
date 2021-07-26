package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.OrderDetails;
import com.sliit.chatApplication.repository.entity.User;


import java.util.List;


public class CartItemDTO extends SuperDTO {

    private long cartItemId;
    private Item item;
    private long quantity;
    private User user;
    private String sessionId;

    public CartItemDTO() {
    }

    public CartItemDTO(long cartItemId, Item item, long quantity, User user, String sessionId) {
        this.cartItemId = cartItemId;
        this.item = item;
        this.quantity = quantity;
        this.user = user;
        this.sessionId = sessionId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
