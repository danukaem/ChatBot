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

    CartItemRepository cartItemRepository;

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
    public List<CartItemDTO> getCartItemList() {
        return Converter.getDTOList(cartItemRepository.findAll());
    }
}
