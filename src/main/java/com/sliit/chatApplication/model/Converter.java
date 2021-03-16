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
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setGender(userDTO.getGender());
            user.setBirthDay(userDTO.getBirthDay());
            user.setCountry(userDTO.getCountry());
            user.setCity(userDTO.getCity());
            return (T) user;
        } else if (superDTO instanceof ItemDTO) {
            ItemDTO itemDTO = (ItemDTO) superDTO;
            Item item = new Item();
            item.setItemId(itemDTO.getItemId());
            item.setItemName(itemDTO.getItemName());
            item.setDescription(itemDTO.getDescription());
            item.setItemCode(itemDTO.getItemCode());
            item.setImgSrc(itemDTO.getImgSrc());
            item.setCategory(itemDTO.getCategory());
            item.setDiscountPercentage(itemDTO.getDiscountPercentage());
            item.setPrice(itemDTO.getPrice());
            return (T) item;
        } else if (superDTO instanceof CartItemDTO) {
            CartItemDTO cartItemDTO = (CartItemDTO) superDTO;
            CartItem cartItem = new CartItem();
            cartItem.setCartItemId(cartItemDTO.getCartItemId());
            cartItem.setItem(cartItemDTO.getItem());
            cartItem.setQuantity(cartItemDTO.getQuantity());
            cartItem.setOrderDetails(cartItemDTO.getOrderDetails());
            cartItem.setUserId(cartItemDTO.getUserId());
            cartItem.setIpAddress(cartItemDTO.getIpAddress());
            return (T) cartItem;
        } else if (superDTO instanceof OrderDetailsDTO) {
            OrderDetailsDTO orderDetailsDTO = (OrderDetailsDTO) superDTO;
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(orderDetailsDTO.getOrderId());
            orderDetails.setUser(orderDetailsDTO.getUser());
            orderDetails.setOrderAmount(orderDetailsDTO.getOrderAmount());
            orderDetails.setPaid(orderDetailsDTO.isPaid());
            orderDetails.setOrderDate(orderDetailsDTO.getOrderDate());
            orderDetails.setPurchaseDate(orderDetailsDTO.getPurchaseDate());
            return (T) orderDetails;
        } else if (superDTO instanceof ChatMessageDTO) {
            ChatMessageDTO chatMessageDTO = (ChatMessageDTO) superDTO;
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setChatId(chatMessageDTO.getChatId());
            chatMessage.setUserId(chatMessageDTO.getUserId());
            chatMessage.setChatSessionId(chatMessageDTO.getChatSessionId());
            chatMessage.setIpAddress(chatMessageDTO.getIpAddress());
            chatMessage.setChatMember(chatMessageDTO.getChatMember());
            chatMessage.setChatMessage(chatMessageDTO.getChatMessage());
            chatMessage.setCartId(chatMessageDTO.getCartId());
            chatMessage.setOrderId(chatMessageDTO.getOrderId());
            chatMessage.setStateOfOrder(chatMessageDTO.getStateOfOrder());
            return (T) chatMessage;
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
            return (T) new ItemDTO(item.getItemId(), item.getItemName(), item.getItemCode(), item.getDescription(), item.getImgSrc(), item.getCategory(), item.getPrice(), item.getDiscountPercentage());
        } else if (superEntity instanceof CartItem) {
            CartItem cartItem = (CartItem) superEntity;
            return (T) new CartItemDTO(cartItem.getCartItemId(), cartItem.getItem(), cartItem.getQuantity(), cartItem.getOrderDetails(), cartItem.getUserId(), cartItem.getIpAddress());
        } else if (superEntity instanceof OrderDetails) {
            OrderDetails orderDetails = (OrderDetails) superEntity;
            return (T) new OrderDetailsDTO(orderDetails.getOrderId(), orderDetails.getOrderAmount(), orderDetails.getOrderDate(), orderDetails.getPurchaseDate(), orderDetails.getUser(), orderDetails.isPaid(), null);
        } else if (superEntity instanceof ChatMessage) {
            ChatMessage chatMessage = (ChatMessage) superEntity;
            return (T) new ChatMessageDTO(chatMessage.getChatId(), chatMessage.getChatSessionId(), chatMessage.getUserId(), chatMessage.getIpAddress(), chatMessage.getChatMember(), chatMessage.getChatMessage(), chatMessage.getCartId(), chatMessage.getOrderId(), chatMessage.getStateOfOrder());
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
