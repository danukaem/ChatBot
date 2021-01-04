package com.sliit.chatApplication.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
