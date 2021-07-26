package com.sliit.chatApplication.service;


import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.ItemExtractRasaDTO;
import com.sliit.chatApplication.model.StateOfOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChatService {

    ChatMessageDTO saveChatMessage(ChatMessageDTO chatMessageDTO);

    ResponseEntity<List<ChatMessageDTO>> getChatMessagesList(String userId);

    ResponseEntity<List<ChatMessageDTO>> getChatResponse(String chatMessage, String chatSessionId, String userId);

    ResponseEntity<String> chatRasaLoginResponse(String chatMessage, String chatSessionId, String userId);

    ResponseEntity generateChatModel();

    String itemExtractRasaDataSave(ItemExtractRasaDTO itemExtractRasaDTO);
}
