package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.CartItemDTO;
import com.sliit.chatApplication.model.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartItemService {
    CartItemDTO addCartItem(CartItemDTO userDTO);
    List<CartItemDTO> addCartItems(List<CartItemDTO> userDTOs);
    List<CartItemDTO> getCartItemList();
    List<CartItemDTO> getCartItemListByUserId(long userId);
    ResponseEntity<List<ItemDTO>> getRecommendCartItemListByUserId(long userId) throws Exception;
    ResponseEntity<List<ItemDTO>> getRecommendCartItemListByIpAddress(String ipAddress) throws Exception;
    List<CartItemDTO> getCartItemListByIp(String ip);
    List<ItemDTO> findRecommendedItems(List<Integer> resList);
}
