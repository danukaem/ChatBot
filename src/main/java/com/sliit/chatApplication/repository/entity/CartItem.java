package com.sliit.chatApplication.repository.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CartItem extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    long cartItemId;
    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    private Item item;
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "orderDetailId", referencedColumnName = "orderId")
    private OrderDetails orderDetails;
    private long userId;
    private String ipAddress;

    public CartItem() {
    }

    public CartItem(Item item, long quantity, OrderDetails orderDetails, long userId, String ipAddress) {
        this.item = item;
        this.quantity = quantity;
        this.orderDetails = orderDetails;
        this.userId = userId;
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
