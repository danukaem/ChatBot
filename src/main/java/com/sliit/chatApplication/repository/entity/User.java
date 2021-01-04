package com.sliit.chatApplication.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId;
    String userName;
//    @OneToMany(mappedBy = "user")
//    private List<OrderDetails> orderList;

}
