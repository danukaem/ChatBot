package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.model.StateOfOrder;
import com.sliit.chatApplication.repository.ChatMessageRepository;
import com.sliit.chatApplication.repository.entity.ChatMessage;
import com.sliit.chatApplication.service.ChatService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
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
                                          StateOfOrder stateOfOrder,
                                          String cartId, String orderId) {


        ChatMessage userChatMessageObj = new ChatMessage();
        userChatMessageObj.setChatMessage(chatMessage);
        userChatMessageObj.setChatSessionId(chatSessionId);
        userChatMessageObj.setUserId(userId);
        userChatMessageObj.setIpAddress(ipAddress);
        userChatMessageObj.setOrderId(orderId);
        userChatMessageObj.setStateOfOrder(stateOfOrder);
        userChatMessageObj.setCartId(cartId);
        userChatMessageObj.setChatMember(ChatMessageDTO.ChatMember.USER);
        chatMessageRepository.save(userChatMessageObj);

        ChatMessage robotChatMessageObj = new ChatMessage();


        String url = chatUrl + "chat?message=" + chatMessage;
        ResponseEntity responseEntity = this.httpService.sendHttpGetUrlConnection(url);

        robotChatMessageObj.setChatMember(ChatMessageDTO.ChatMember.ROBOT);

        JSONObject jsonBody = new JSONObject(responseEntity);
        JSONObject jsonUserMessage = new JSONObject(jsonBody.getString("body"));
        String userMessage = jsonUserMessage.getString("userMessage");
        robotChatMessageObj.setChatMessage(userMessage);

        robotChatMessageObj.setChatSessionId(userChatMessageObj.getChatSessionId());
        robotChatMessageObj.setUserId(userChatMessageObj.getUserId());
        robotChatMessageObj.setIpAddress(userChatMessageObj.getIpAddress());
        robotChatMessageObj.setOrderId(userChatMessageObj.getOrderId());
        robotChatMessageObj.setStateOfOrder(userChatMessageObj.getStateOfOrder());
        robotChatMessageObj.setCartId(userChatMessageObj.getCartId());


        chatMessageRepository.save(robotChatMessageObj);

        return responseEntity;
    }


    @Scheduled(fixedRate = 100*3600*24)
    public ResponseEntity generateChatModel() {
        String url = chatUrl + "generateChatModel";
        return this.httpService.sendHttpGetUrlConnection(url);

    }


}
