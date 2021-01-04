package com.sliit.chatApplication.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Item extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long itemId;
    String itemName;
    String itemCode;
    String description;
    long price;
//    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
//    List<CartItem> cartItems;


}
