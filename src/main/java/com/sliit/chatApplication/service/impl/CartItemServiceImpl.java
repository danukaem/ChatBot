package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.CartItemDTO;
import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.repository.CartItemRepository;
import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;

    CartItemServiceImpl() {
    }

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItemDTO addCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemRepository.save(Converter.getEntity(cartItemDTO));
        return Converter.getDTO(cartItem);
    }

    @Override
    public List<CartItemDTO> addCartItems(List<CartItemDTO> userDTOs) {
        List<CartItem> cartItems = cartItemRepository.saveAll(Converter.getEntityList(userDTOs));

        return Converter.getDTOList(cartItems);
    }

    @Override
    public List<CartItemDTO> getCartItemList() {
        return Converter.getDTOList(cartItemRepository.findAll());
    }

    @Override
    public List<CartItemDTO> getCartItemListByUserId(long userId) {
        List<CartItem> cartItems = cartItemRepository.findByUserIdOrIpAddress(userId,userId);
        if (cartItems.size() > 0) {
            return Converter.getDTOList(cartItems);

        } else {
            return null;

        }
    }
}
