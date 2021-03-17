package com.sliit.chatApplication.model;

public class ChatMessageDTO extends SuperDTO {


    private long chatId;
    private String chatSessionId;
    private String userId;
    private String ipAddress;
    private ChatMember chatMember;
    private String chatMessage;
    private String cartId;
    private String orderId;
    private StateOfOrder stateOfOrder;

    public ChatMessageDTO() {
    }

    public ChatMessageDTO(long chatId, String chatSessionId, String userId, String ipAddress, ChatMember chatMember, String chatMessage, String cartId, String orderId, StateOfOrder stateOfOrder) {
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

    public ChatMember getChatMember() {
        return chatMember;
    }

    public void setChatMember(ChatMember chatMember) {
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

    public StateOfOrder getStateOfOrder() {
        return stateOfOrder;
    }

    public void setStateOfOrder(StateOfOrder stateOfOrder) {
        this.stateOfOrder = stateOfOrder;
    }

    @Override
    public String toString() {
        return "ChatMessageDTO{" +
                "chatId=" + chatId +
                ", chatSessionId='" + chatSessionId + '\'' +
                ", userId='" + userId + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", chatMember=" + chatMember +
                ", chatMessage='" + chatMessage + '\'' +
                ", cartId='" + cartId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", stateOfOrder=" + stateOfOrder +
                '}';
    }

    public enum ChatMember {
        ROBOT, USER
    }

}



