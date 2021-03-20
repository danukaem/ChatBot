package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.CartItemDTO;
import com.sliit.chatApplication.model.ItemDTO;

import java.util.List;

public interface CartItemService {
    CartItemDTO addCartItem(CartItemDTO userDTO);
    List<CartItemDTO> addCartItems(List<CartItemDTO> userDTOs);
    List<CartItemDTO> getCartItemList();
    List<CartItemDTO> getCartItemListByUserId(long userId);
    List<ItemDTO> getRecommendCartItemListByUserId(long userId);
    List<CartItemDTO> getCartItemListByIp(String ip);
    List<ItemDTO> findRecommendedItems(List<List<Float>> resList);
}
