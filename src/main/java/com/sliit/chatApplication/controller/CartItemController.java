package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.CartItemDTO;
import com.sliit.chatApplication.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/addCartItem")
    CartItemDTO addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        return cartItemService.addCartItem(cartItemDTO);
    }

    @GetMapping("/getCartItemList")
    List<CartItemDTO> getCartItemList() {
        return cartItemService.getCartItemList();
    }


}
