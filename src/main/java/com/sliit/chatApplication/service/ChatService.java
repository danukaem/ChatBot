package com.sliit.chatApplication.service;


import com.sliit.chatApplication.model.ChatMessageDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChatService {

    ChatMessageDTO saveChatMessage(ChatMessageDTO chatMessageDTO);

    List<ChatMessageDTO> getChatMessagesList();

    ResponseEntity getChatResponse(String message,String sessionId);
}
