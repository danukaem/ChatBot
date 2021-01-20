package com.sliit.chatApplication.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class CartItem extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long cartItemId;
    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    Item item;
    long quantity;
    @ManyToOne
    @JoinColumn(name = "orderDetailId", referencedColumnName = "orderId")
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
