package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class OrderDetailsDTO extends SuperDTO {

    private long orderId;
    private long orderAmount;
    private Date orderDate;
    private Date purchaseDate;
    private User user;
    private boolean isPaid;

    private List<CartItem> cartItems;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(long orderId, long orderAmount, Date orderDate, Date purchaseDate, User user, boolean isPaid, List<CartItem> cartItems) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.isPaid = isPaid;
        this.cartItems = cartItems;
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

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" +
                "orderId=" + orderId +
                ", orderAmount=" + orderAmount +
                ", orderDate=" + orderDate +
                ", purchaseDate=" + purchaseDate +
                ", user=" + user +
                ", isPaid=" + isPaid +
                ", cartItems=" + cartItems +
                '}';
    }
}
