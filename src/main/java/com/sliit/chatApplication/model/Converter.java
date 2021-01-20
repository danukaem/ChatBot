package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.*;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static <T extends SuperEntity> T getEntity(SuperDTO superDTO) {
        if (superDTO instanceof UserDTO) {
            UserDTO userDTO = (UserDTO) superDTO;
            User user = new User();
            user.setUserId(userDTO.getUserId());
            user.setUserName(userDTO.getUserName());
            return (T) user;
        } else if (superDTO instanceof ItemDTO) {
            ItemDTO itemDTO = (ItemDTO) superDTO;
            Item item = new Item();
            item.setItemId(itemDTO.getItemId());
            item.setItemName(itemDTO.getItemName());
            item.setDescription(itemDTO.getDescription());
            item.setItemCode(itemDTO.getItemCode());
            item.setPrice(itemDTO.getPrice());
            return (T) item;
        } else if (superDTO instanceof CartItemDTO) {
            CartItemDTO cartItemDTO = (CartItemDTO) superDTO;
            CartItem cartItem = new CartItem();
            cartItem.setCartItemId(cartItemDTO.getCartItemId());
            cartItem.setItem(cartItemDTO.getItem());
            cartItem.setQuantity(cartItemDTO.getQuantity());
            cartItem.setOrderDetails(cartItemDTO.getOrderDetails());
            return (T) cartItem;
        } else if (superDTO instanceof OrderDetailsDTO) {
            OrderDetailsDTO orderDetailsDTO = (OrderDetailsDTO) superDTO;
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(orderDetailsDTO.getOrderId());
            orderDetails.setUser(orderDetailsDTO.getUser());
            orderDetails.setOrderAmount(orderDetailsDTO.getOrderAmount());
            orderDetails.setOrderDate(orderDetailsDTO.getOrderDate());
            orderDetails.setPurchaseDate(orderDetailsDTO.getPurchaseDate());
            orderDetails.setCartItems(orderDetailsDTO.getCartItems());
            return (T) orderDetails;
        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperDTO> T getDTO(SuperEntity superEntity) {
        if (superEntity instanceof User) {
            User user = (User) superEntity;
            return (T) new UserDTO(user.getUserId(), user.getUserName(), user.getEmail(), user.getPassword(), user.getGender(), user.getBirthDay(), user.getCountry(), user.getCity());
        } else if (superEntity instanceof Item) {
            Item item = (Item) superEntity;
            return (T) new ItemDTO(item.getItemId(), item.getItemName(), item.getItemCode(), item.getDescription(), item.getPrice());
        } else if (superEntity instanceof CartItem) {
            CartItem cartItem = (CartItem) superEntity;
            return (T) new CartItemDTO(cartItem.getCartItemId(),cartItem.getItem(),cartItem.getQuantity(),cartItem.getOrderDetails());
        } else if (superEntity instanceof OrderDetails) {
            OrderDetails orderDetails = (OrderDetails) superEntity;
            return (T) new OrderDetailsDTO(orderDetails.getOrderId(), orderDetails.getOrderAmount(), orderDetails.getOrderDate(), orderDetails.getPurchaseDate(), orderDetails.getUser(), orderDetails.getCartItems());
        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> superDTOS) {
        List<T> entityList = new ArrayList<>();
        superDTOS.forEach(s -> {
            SuperEntity entity = Converter.getEntity(s);
            entityList.add((T) entity);
        });
        return entityList;
    }


    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> superEntities) {
        List<T> dtoList = new ArrayList<>();
        superEntities.forEach(s -> {
            SuperDTO dto = Converter.getDTO(s);
            dtoList.add((T) dto);
        });
        return dtoList;
    }
}
