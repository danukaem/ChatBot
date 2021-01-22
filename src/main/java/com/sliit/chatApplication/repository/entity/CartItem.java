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
    Item item;
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "orderDetailId", referencedColumnName = "orderId")
    private
    OrderDetails orderDetails;

    public CartItem() {
    }

    public CartItem(Item item, long quantity, OrderDetails orderDetails) {
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
