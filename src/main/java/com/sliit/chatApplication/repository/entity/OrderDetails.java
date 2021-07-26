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
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private
    User user;
    private StateOfOrder stateOfOrder;
    private String sessionId;



    public OrderDetails() {
    }

    public OrderDetails(long orderId, long orderAmount, Date orderDate, Date purchaseDate, User user, StateOfOrder stateOfOrder, String sessionId) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.stateOfOrder = stateOfOrder;
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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
                ", user=" + user +
                ", stateOfOrder=" + stateOfOrder +
                '}';
    }
}
