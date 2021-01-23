package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.CartItemDTO;

import java.util.List;

public interface CartItemService {
    CartItemDTO addCartItem(CartItemDTO userDTO);
    List<CartItemDTO> addCartItems(List<CartItemDTO> userDTOs);
    List<CartItemDTO> getCartItemList();
    List<CartItemDTO> getCartItemListByUserId(long userId);
    List<CartItemDTO> getCartItemListByIp(String ip);

}
