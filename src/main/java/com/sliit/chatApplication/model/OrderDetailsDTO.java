package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO extends SuperDTO {

    long orderId;
    long orderAmount;
    Date orderDate;
    Date purchaseDate;
    User user;
    List<CartItem> cartItems;


}
