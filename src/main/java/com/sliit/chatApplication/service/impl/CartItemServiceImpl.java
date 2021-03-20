package com.sliit.chatApplication.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sliit.chatApplication.model.*;
import com.sliit.chatApplication.repository.CartItemRepository;
import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.service.CartItemService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    @Value("${chatUrl}")
    String chatUrl;
    @Autowired
    HttpService httpService;

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
        List<CartItem> cartItems = cartItemRepository.findAllByUserId(userId);
        if (cartItems.size() > 0) {
            return Converter.getDTOList(cartItems);
        } else {
            return null;
        }
    }

    @Override
    public List<ItemDTO> getRecommendCartItemListByUserId(long userId) {
        String url = chatUrl + "getRecommendCartItems?userId=" + userId;
        ResponseEntity getRecommendCartItems = httpService.sendHttpGetUrlConnection(url);

        JSONObject jsonObj = new JSONObject(getRecommendCartItems);
        JSONObject jsonBody = new JSONObject(jsonObj.getString("body"));
        Object forecastResults = jsonBody.get("forecastResults");
        String resultList = forecastResults.toString();
        String splitedResultList = resultList.substring(1, resultList.length() - 1);
        splitedResultList = splitedResultList.substring(1, splitedResultList.length() - 1);
        String stringList[] = splitedResultList.split("], \\[");
        List<List<Float>> resList = new ArrayList<>();
        for (String a : stringList) {
            String sb[] = a.split(",");
            List<Float> list = new ArrayList<>();
            for (String b : sb) {
                list.add(Float.valueOf(b));
            }
            resList.add(list);
        }

        return findRecommendedItems(resList);
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

    public List<ItemDTO> findRecommendedItems(List<List<Float>> resList) {

        System.out.println(resList);
        return null;
    }


}
