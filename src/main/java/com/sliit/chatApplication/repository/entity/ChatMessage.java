package com.sliit.chatApplication.repository.entity;

import com.sliit.chatApplication.model.ChatMessageDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatMessage  extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatId;
    private String chatSessionId;
    private String userId;
    private String ipAddress;
    private ChatMessageDTO.ChatMember chatMember;
    private String chatMessage;
    private String cartId;
    private String orderId;
    private ChatMessageDTO.StateOfOrder stateOfOrder;

    public ChatMessage() {
    }

    public ChatMessage(long chatId, String chatSessionId, String userId, String ipAddress, ChatMessageDTO.ChatMember chatMember, String chatMessage, String cartId, String orderId, ChatMessageDTO.StateOfOrder stateOfOrder) {
        this.chatId = chatId;
        this.chatSessionId = chatSessionId;
        this.userId = userId;
        this.ipAddress = ipAddress;
        this.chatMember = chatMember;
        this.chatMessage = chatMessage;
        this.cartId = cartId;
        this.orderId = orderId;
        this.stateOfOrder = stateOfOrder;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getChatSessionId() {
        return chatSessionId;
    }

    public void setChatSessionId(String chatSessionId) {
        this.chatSessionId = chatSessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public ChatMessageDTO.ChatMember getChatMember() {
        return chatMember;
    }

    public void setChatMember(ChatMessageDTO.ChatMember chatMember) {
        this.chatMember = chatMember;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ChatMessageDTO.StateOfOrder getStateOfOrder() {
        return stateOfOrder;
    }

    public void setStateOfOrder(ChatMessageDTO.StateOfOrder stateOfOrder) {
        this.stateOfOrder = stateOfOrder;
    }
}
