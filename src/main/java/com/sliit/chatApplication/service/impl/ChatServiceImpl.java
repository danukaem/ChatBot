package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.repository.ChatMessageRepository;
import com.sliit.chatApplication.repository.entity.ChatMessage;
import com.sliit.chatApplication.service.ChatService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Value("${chatUrl}")
    String chatUrl;
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    HttpService httpService;

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

    public ResponseEntity getChatResponse(String chatMessage, String chatSessionId, String userId, String ipAddress,
                                          ChatMessageDTO.StateOfOrder stateOfOrder,
                                          String cartId, String orderId) {


        ChatMessage robotChatMessageObj = new ChatMessage();
        robotChatMessageObj.setChatMessage(chatMessage);
        robotChatMessageObj.setChatSessionId(chatSessionId);
        robotChatMessageObj.setUserId(userId);
        robotChatMessageObj.setIpAddress(ipAddress);
        robotChatMessageObj.setOrderId(orderId);
        robotChatMessageObj.setStateOfOrder(stateOfOrder);
        robotChatMessageObj.setCartId(cartId);
        robotChatMessageObj.setChatMember(ChatMessageDTO.ChatMember.ROBOT);
        chatMessageRepository.save(robotChatMessageObj);
        String url = chatUrl + "chat?message=" + chatMessage;
        ResponseEntity responseEntity = this.httpService.sendHttpGetUrlConnection(url);

        robotChatMessageObj.setChatMember(ChatMessageDTO.ChatMember.USER);

        JSONObject jsonBody = new JSONObject(responseEntity);
        JSONObject jsonUserMessage=new JSONObject(jsonBody.getString("body"));
        String userMessage = jsonUserMessage.getString("userMessage");
        robotChatMessageObj.setChatMessage(userMessage);
        chatMessageRepository.save(robotChatMessageObj);

        return responseEntity;
    }

}
