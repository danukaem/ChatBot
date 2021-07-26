package com.sliit.chatApplication.repository.entity;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.StateOfOrder;

import javax.persistence.*;

@Entity
public class ChatMessage extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chatId;
    private String sessionId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
    private ChatMessageDTO.ChatMember chatMember;
    private String chatMessage;

    public ChatMessage() {
    }

    public ChatMessage(long chatId, String sessionId, User user, ChatMessageDTO.ChatMember chatMember, String chatMessage) {
        this.chatId = chatId;
        this.sessionId = sessionId;
        this.user = user;
        this.chatMember = chatMember;
        this.chatMessage = chatMessage;
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


}
