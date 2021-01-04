package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.CartItemDTO;

import java.util.List;

public interface CartItemService {
    CartItemDTO addCartItem(CartItemDTO userDTO);
    List<CartItemDTO> getCartItemList();
}
