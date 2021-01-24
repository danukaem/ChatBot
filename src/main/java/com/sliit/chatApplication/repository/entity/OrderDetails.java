package com.sliit.chatApplication.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity

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


    public OrderDetails() {
    }

    public OrderDetails(long orderAmount, Date orderDate, Date purchaseDate, User user) {
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.purchaseDate = purchaseDate;
        this.user = user;
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


}
