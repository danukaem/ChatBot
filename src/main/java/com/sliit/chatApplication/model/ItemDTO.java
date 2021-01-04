package com.sliit.chatApplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ItemDTO extends SuperDTO {


    long itemId;
    String itemName;
    String itemCode;
    String Description;
    long price;


}
