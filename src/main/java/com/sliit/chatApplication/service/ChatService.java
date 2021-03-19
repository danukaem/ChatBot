package com.sliit.chatApplication.service;


import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.StateOfOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChatService {

    ChatMessageDTO saveChatMessage(ChatMessageDTO chatMessageDTO);

    List<ChatMessageDTO> getChatMessagesList();

    ResponseEntity getChatResponse(String chatMessage, String chatSessionId, String userId, String ipAddress, StateOfOrder stateOfOrder, String cartId, String orderId);

     ResponseEntity generateChatModel();
}
