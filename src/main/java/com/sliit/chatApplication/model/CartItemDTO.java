package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO extends SuperDTO {

    long cartItemId;
    Item item;
    long quantity;
    OrderDetails orderDetails;



}
