package com.sliit.chatApplication.service;


import com.sliit.chatApplication.model.ChatMessageDTO;

import java.util.List;

public interface ChatService {

    ChatMessageDTO saveChatMessage(ChatMessageDTO chatMessageDTO);

    List<ChatMessageDTO> getChatMessagesList();
}
