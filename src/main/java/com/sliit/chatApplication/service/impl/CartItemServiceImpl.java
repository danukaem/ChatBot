package com.sliit.chatApplication.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sliit.chatApplication.model.*;
import com.sliit.chatApplication.repository.CartItemRepository;
import com.sliit.chatApplication.repository.ItemRepository;
import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.repository.entity.Item;
import com.sliit.chatApplication.service.CartItemService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    private ItemRepository itemRepository;

    @Value("${chatUrl}")
    String chatUrl;
    @Autowired
    HttpService httpService;

    CartItemServiceImpl() {
    }

    @Autowired

    public CartItemServiceImpl(CartItemRepository cartItemRepository, ItemRepository itemRepository) {
        this.cartItemRepository = cartItemRepository;
        this.itemRepository = itemRepository;
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
    public ResponseEntity<List<ItemDTO>> getRecommendCartItemListByUserId(long userId) {
        String url = chatUrl + "itemCategoryDemandForecastingByUserId?userId=" + userId;
        ResponseEntity response = httpService.sendHttpGetUrlConnection(url);
        try {
            return new ResponseEntity<>(findRecommendedItems(getArrayListFromResponse(response)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getRecommendCartItemListByIpAddress(String ipAddress) {
        String url = chatUrl + "itemCategoryDemandForecastingByIpAddress?ipAddress=" + ipAddress;
        ResponseEntity response = httpService.sendHttpGetUrlConnection(url);
        try {
            return new ResponseEntity<>(findRecommendedItems(getArrayListFromResponse(response)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getRecommendCartItemListByUserIdChat(long userId) {
        String url = chatUrl + "itemCategoryDemandForecastingByUserIdChat?userId=" + userId;
        ResponseEntity response = httpService.sendHttpGetUrlConnection(url);
        try {
            return new ResponseEntity<>(findRecommendedItems(getArrayListFromResponse(response)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ItemDTO>> getRecommendCartItemListByIpAddressChat(String ipAddress) {
        String url = chatUrl + "itemCategoryDemandForecastingByIpAddressChat?ipAddress=" + ipAddress;
        ResponseEntity response = httpService.sendHttpGetUrlConnection(url);
        try {
            return new ResponseEntity<>(findRecommendedItems(getArrayListFromResponse(response)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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

    public List<ItemDTO> findRecommendedItems(List<Integer> resList) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> duplicates = new HashMap<>();
        for (Integer integer : resList) {
            if (duplicates.containsKey(integer)) {
                duplicates.put(integer, duplicates.get(integer) + 1);
            } else {
                duplicates.put(integer, 1);
            }
            set.add(integer);
        }

        List<Integer> list = new ArrayList<>(set);

        int recommendCategory = 0;
        int maxCount = 0;

        for (int i = 0; i < list.size(); i++) {
            if (duplicates.get(list.get(i)) > maxCount) {
                maxCount = duplicates.get(list.get(i));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (duplicates.get(list.get(i)) == maxCount) {
                recommendCategory = list.get(i);
            }

        }


        System.out.println(recommendCategory);

        List<Item> itemsbyCategory = itemRepository.findItemsbyCategory(recommendCategory);

        return Converter.getDTOList(itemsbyCategory);


    }

    List<Integer> getArrayListFromResponse(ResponseEntity response) {
        List<Integer> resList = new ArrayList<>();
        try {
            JSONObject jsonObj = new JSONObject(response);
            JSONObject jsonBody = new JSONObject(jsonObj.getString("body"));
            Object forecastResults = jsonBody.get("forecastResults");
            String resultList = forecastResults.toString();
            String splitedResultList = resultList.substring(1, resultList.length() - 1);
            splitedResultList = splitedResultList.substring(1, splitedResultList.length() - 1);
            String stringList[] = splitedResultList.split("]\\n \\[");
            for (int i = 0; i < stringList.length; i++) {
                resList.add(BigDecimal.valueOf(Float.valueOf(stringList[i]))
                        .setScale(0, BigDecimal.ROUND_HALF_DOWN)
                        .intValue());
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }

        return resList;
    }


}
