package com.sliit.chatApplication.repository.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CartItem extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    long cartItemId;
    @ManyToMany
    @JoinTable(
            name = "cart_item_item",
            joinColumns = @JoinColumn(name = "cartItemId"),
            inverseJoinColumns = @JoinColumn(name = "itemId")
    )
    private
    List<Item> items;
    private long quantity;
    @ManyToOne
    @JoinColumn(name = "orderDetailId", referencedColumnName = "orderId")
    private
    OrderDetails orderDetails;

    public CartItem() {
    }

    public CartItem(List<Item> items, long quantity, OrderDetails orderDetails) {
        this.items = items;
        this.quantity = quantity;
        this.orderDetails = orderDetails;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
