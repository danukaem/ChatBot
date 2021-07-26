package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.CartItemDTO;
import com.sliit.chatApplication.model.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartItemService {
    CartItemDTO addCartItem(CartItemDTO userDTO);

    List<CartItemDTO> addCartItems(List<CartItemDTO> userDTOs);

    List<CartItemDTO> getCartItemListByUserId(long userId);


    List<CartItemDTO> getCartItemListByIp(String ip);

}
