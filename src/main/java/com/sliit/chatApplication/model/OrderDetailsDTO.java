package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


public class OrderDetailsDTO extends SuperDTO {

    private long orderId;
    private long orderAmount;
    private Date orderDate;
    private Date purchaseDate;
    private User user;

    private List<CartItem> cartItems;
    private StateOfOrder stateOfOrder;
    private String sessionId;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(long orderId, long orderAmount, Date orderDate, Date purchaseDate, User user, List<CartItem> cartItems, StateOfOrder stateOfOrder, String sessionId) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.cartItems = cartItems;
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public StateOfOrder getStateOfOrder() {
        return stateOfOrder;
    }

    public void setStateOfOrder(StateOfOrder stateOfOrder) {
        this.stateOfOrder = stateOfOrder;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "orderId=" + orderId +
                ", orderAmount=" + orderAmount +
                ", orderDate=" + orderDate +
                ", purchaseDate=" + purchaseDate +
                ", user=" + user +
                ", cartItems=" + cartItems +
                ", stateOfOrder=" + stateOfOrder +
                '}';
    }
}
