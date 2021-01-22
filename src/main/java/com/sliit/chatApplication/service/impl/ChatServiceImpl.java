package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.repository.ChatMessageRepository;
import com.sliit.chatApplication.repository.entity.ChatMessage;
import com.sliit.chatApplication.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    ChatMessageRepository chatMessageRepository;


    public ChatServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public ChatMessageDTO saveChatMessage(ChatMessageDTO chatMessageDTO) {

        ChatMessage chatMessage = chatMessageRepository.save(Converter.getEntity(chatMessageDTO));
        return Converter.getDTO(chatMessage);
    }

    @Override
    public List<ChatMessageDTO> getChatMessagesList() {

        return Converter.getDTOList(chatMessageRepository.findAll());
    }
}
