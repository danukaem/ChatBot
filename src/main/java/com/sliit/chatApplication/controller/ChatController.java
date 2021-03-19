package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.StateOfOrder;
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
    public Object getChatResponse(@RequestParam("chatMessage") String chatMessage, @RequestParam("chatSessionId") String chatSessionId
            , @RequestParam("userId") String userId, @RequestParam("ipAddress") String ipAddress
            , @RequestParam("stateOfOrder") StateOfOrder stateOfOrder
            , @RequestParam("cartId") String cartId, @RequestParam("orderId") String orderId) {
        ResponseEntity responseEntity = chatService.getChatResponse(chatMessage, chatSessionId, userId, ipAddress, stateOfOrder, cartId, orderId);
        return responseEntity.getBody();
    }

    @GetMapping("/generateChatModel")
    public ResponseEntity generateChatModel() {
        return chatService.generateChatModel();
    }

}
