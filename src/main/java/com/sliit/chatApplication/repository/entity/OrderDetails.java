package com.sliit.chatApplication.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class OrderDetails extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long orderId;
    long orderAmount;
    Date orderDate;
    Date purchaseDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    User user;
    @OneToMany(mappedBy = "orderDetails",fetch = FetchType.EAGER)
    List<CartItem> cartItems;

    public OrderDetails() {
    }

    public OrderDetails(long orderAmount, Date orderDate, Date purchaseDate, User user, List<CartItem> cartItems) {
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.cartItems = cartItems;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
