package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/chatMessage")
public class ChatController {

    ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @PostMapping("/saveChatMessage")
    public ChatMessageDTO saveChatMessage(@RequestBody ChatMessageDTO chatMessageDTO){


        return chatService.saveChatMessage(chatMessageDTO);
    }

    @GetMapping("/getChatMessageList")
    public List<ChatMessageDTO> getChatMessageList(){

        return chatService.getChatMessagesList();
    }

}
