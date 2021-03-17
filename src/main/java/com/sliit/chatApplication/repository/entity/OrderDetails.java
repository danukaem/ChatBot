package com.sliit.chatApplication.repository.entity;

import com.sliit.chatApplication.model.StateOfOrder;

import javax.persistence.*;
import java.util.Date;

@Entity

public class OrderDetails extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    long orderId;
    private long orderAmount;
    private Date orderDate;
    private Date purchaseDate;
    private boolean isPaid;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private
    User user;
    private StateOfOrder stateOfOrder;


    public OrderDetails() {
    }

    public OrderDetails(long orderAmount, Date orderDate, Date purchaseDate, boolean isPaid, User user, StateOfOrder stateOfOrder) {
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.purchaseDate = purchaseDate;
        this.isPaid = isPaid;
        this.user = user;
        this.stateOfOrder = stateOfOrder;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
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

    public StateOfOrder getStateOfOrder() {
        return stateOfOrder;
    }

    public void setStateOfOrder(StateOfOrder stateOfOrder) {
        this.stateOfOrder = stateOfOrder;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", orderAmount=" + orderAmount +
                ", orderDate=" + orderDate +
                ", purchaseDate=" + purchaseDate +
                ", isPaid=" + isPaid +
                ", user=" + user +
                ", stateOfOrder=" + stateOfOrder +
                '}';
    }
}
