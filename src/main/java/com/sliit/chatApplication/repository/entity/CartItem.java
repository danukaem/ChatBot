package com.sliit.chatApplication.repository.entity;

import javax.persistence.*;

@Entity
public class CartItem extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    long cartItemId;
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "itemId")
    private Item item;
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "order_detail_id", referencedColumnName = "orderId")
    private OrderDetails orderDetails;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
    private String sessionId;

    public CartItem() {
    }

    public CartItem(long cartItemId, Item item, long quantity, OrderDetails orderDetails, User user, String sessionId) {
        this.cartItemId = cartItemId;
        this.item = item;
        this.quantity = quantity;
        this.orderDetails = orderDetails;
        this.user = user;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
