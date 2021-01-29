package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/chatMessage")
public class ChatController {

    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @PostMapping("/saveChatMessage")
    public ChatMessageDTO saveChatMessage(@RequestBody ChatMessageDTO chatMessageDTO) {


        return chatService.saveChatMessage(chatMessageDTO);
    }

    @GetMapping("/getChatMessageList")
    public List<ChatMessageDTO> getChatMessageList() {

        return chatService.getChatMessagesList();
    }


    @GetMapping("/chat")
    public Object getChatResponse(@RequestParam("message") String message, @RequestParam("sessionId") String sessionId) {
        ResponseEntity responseEntity = chatService.getChatResponse(message, sessionId);
        return responseEntity.getBody();
    }

}
