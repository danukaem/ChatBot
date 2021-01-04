package com.sliit.chatApplication.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

}
