package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.CartItemDTO;
import com.sliit.chatApplication.model.ItemDTO;
import com.sliit.chatApplication.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/addCartItems")
    List<CartItemDTO> addCartItems(@RequestBody List<CartItemDTO> cartItemDTOs) {
        return cartItemService.addCartItems(cartItemDTOs);
    }

    @GetMapping("/getCartItemListByIp/{ip}")
    List<CartItemDTO> getCartItemList(@PathVariable String ip) {
        System.out.println(ip);
        return cartItemService.getCartItemListByIp(ip);
    }

    @GetMapping("/getCartItemListByUserId/{userId}")
    List<CartItemDTO> getCartItemListByUserId(@PathVariable long userId) {
        List<CartItemDTO> cartItemDTOS = cartItemService.getCartItemListByUserId(userId);
        return cartItemDTOS;
    }
    @GetMapping("/getRecommendCartItemListByUserId/{userId}")
    ResponseEntity<List<ItemDTO>> getRecommendCartItemListByUserId(@PathVariable long userId) throws Exception {
        ResponseEntity<List<ItemDTO>>  ItemDTOS = cartItemService.getRecommendCartItemListByUserId(userId);
        return ItemDTOS;
    }
}
