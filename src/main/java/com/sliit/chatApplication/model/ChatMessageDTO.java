package com.sliit.chatApplication.model;

import com.sliit.chatApplication.repository.entity.User;

import java.util.Date;

public class ChatMessageDTO extends SuperDTO {


    private long chatId;
    private String sessionId;
    private User user;
    private ChatMember chatMember;
    private String chatMessage;
    private String time;


    public ChatMessageDTO() {
    }

    public ChatMessageDTO(long chatId, String sessionId, User user, ChatMember chatMember, String chatMessage, String time) {
        this.chatId = chatId;
        this.sessionId = sessionId;
        this.user = user;
        this.chatMember = chatMember;
        this.chatMessage = chatMessage;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "ChatMessageDTO{" +
                "chatId=" + chatId +
                ", sessionId='" + sessionId + '\'' +
                ", user=" + user +
                ", chatMember=" + chatMember +
                ", chatMessage='" + chatMessage + '\'' +
                '}';
    }

    public enum ChatMember {
        ROBOT, USER
    }

}



