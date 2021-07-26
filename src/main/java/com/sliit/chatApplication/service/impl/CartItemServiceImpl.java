package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.*;
import com.sliit.chatApplication.repository.CartItemRepository;
import com.sliit.chatApplication.repository.ItemRepository;
import com.sliit.chatApplication.repository.UserRepository;
import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.repository.entity.SuperEntity;
import com.sliit.chatApplication.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;

    @Value("${chatUrl}")
    String chatUrl;
    @Autowired
    HttpService httpService;

    CartItemServiceImpl() {
    }

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.cartItemRepository = cartItemRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }


    @Override
    public CartItemDTO addCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemRepository.save(Converter.getEntity(cartItemDTO));
        return Converter.getDTO(cartItem);
    }

    @Override
    public List<CartItemDTO> addCartItems(List<CartItemDTO> cartItemDTOS) {
        List<CartItem> entityList = new ArrayList<>();
        cartItemDTOS.forEach(cartItemDTO -> {
            CartItem cartItem = new CartItem();
            if (itemRepository.findById(cartItemDTO.getItem().getItemId()).isPresent()) {
                cartItem.setItem(itemRepository.findById(cartItemDTO.getItem().getItemId()).get());
            }
            if (userRepository.findById(cartItemDTO.getUser().getUserId()).isPresent()) {
                cartItem.setUser(userRepository.findById(cartItemDTO.getUser().getUserId()).get());
            }
            cartItem.setSessionId(cartItemDTO.getSessionId());
            cartItem.setQuantity(cartItemDTO.getQuantity());
            entityList.add(cartItem);

        });
        List<CartItem> cartItems = cartItemRepository.saveAll(entityList);
        return Converter.getDTOList(cartItems);
    }

    @Override
    public List<CartItemDTO> getCartItemListByUserId(long userId) {
        List<CartItem> cartItems = cartItemRepository.findAllByUserId(userId);
        if (cartItems.size() > 0) {
            return Converter.getDTOList(cartItems);
        } else {
            return null;
        }
    }

    @Override
    public List<CartItemDTO> getCartItemListByIp(String ip) {
        List<CartItem> itemList = cartItemRepository.findByIpAddress(ip);
        if (itemList.size() > 0) {
            return Converter.getDTOList(itemList);
        } else {
            return null;
        }
    }


}
