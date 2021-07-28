package com.sliit.chatApplication.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sliit.chatApplication.model.*;
import com.sliit.chatApplication.repository.ChatMessageRepository;
import com.sliit.chatApplication.repository.ItemExtractRasaRepository;
import com.sliit.chatApplication.repository.UserRepository;
import com.sliit.chatApplication.repository.entity.ChatMessage;
import com.sliit.chatApplication.repository.entity.ItemExtractRasa;
import com.sliit.chatApplication.repository.entity.User;
import com.sliit.chatApplication.service.ChatService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableScheduling
@Service
public class ChatServiceImpl implements ChatService {
    @Value("${chatUrl}")
    String chatUrl;
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    HttpService httpService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ItemExtractRasaRepository extractRasaRepository;

    public ChatServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public ChatMessageDTO saveChatMessage(ChatMessageDTO chatMessageDTO) {

        ChatMessage chatMessage = chatMessageRepository.save(Converter.getEntity(chatMessageDTO));
        return Converter.getDTO(chatMessage);
    }

    @Override
    public ResponseEntity<List<ChatMessageDTO>> getChatMessagesList(String userId) {

        if (userId != null) {
            User byUserId = userRepository.findByUserId(Long.parseLong(userId));

            List<ChatMessage> allMessages = new ArrayList<>();
            List<ChatMessageDTO> dtoList = new ArrayList<>();

            if (chatMessageRepository.findAllByUser(byUserId).isPresent()) {
                allMessages = chatMessageRepository.findAllByUser(byUserId).get();
                dtoList = Converter.getDTOList(allMessages);

            }

            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<ChatMessageDTO>> getChatResponse(String chatMessage, String chatSessionId, String userId) {

        try {
            ChatMessage userChatMessageObj = new ChatMessage();
            userChatMessageObj.setChatMessage(chatMessage);
            userChatMessageObj.setSessionId(chatSessionId);
            User byUserId = userRepository.findByUserId(Long.parseLong(userId));
            userChatMessageObj.setUser(byUserId);
            userChatMessageObj.setChatMember(ChatMessageDTO.ChatMember.USER);
            userChatMessageObj.setTime(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
            chatMessageRepository.save(userChatMessageObj);

            ChatMessage robotChatMessageObj = new ChatMessage();
            robotChatMessageObj.setUser(byUserId);
            robotChatMessageObj.setSessionId(chatSessionId);
            robotChatMessageObj.setChatMember(ChatMessageDTO.ChatMember.ROBOT);

            String url = chatUrl;
            RasaChatMessage senderMessage = new RasaChatMessage();
            senderMessage.setSender(Long.toString(byUserId.getUserId()));
            senderMessage.setMessage(chatMessage);
            ResponseEntity responseEntity = this.httpService.sentHttpPostConnection(url, objectMapper.writeValueAsString(senderMessage));
            String res = responseEntity.getBody().toString();
            List<RasaChatMessage> rasaChatMessages = objectMapper.readValue(res, new TypeReference<>() {
            });

            rasaChatMessages.forEach(r -> {
                System.out.println(r.getText());
                robotChatMessageObj.setChatMessage(r.getText());
                robotChatMessageObj.setTime(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
                chatMessageRepository.save(robotChatMessageObj);
            });

            List<ChatMessage> allMessages = new ArrayList<>();
            List<ChatMessageDTO> dtoList = new ArrayList<>();

            if (chatMessageRepository.findAllByUser(byUserId).isPresent()) {
                allMessages = chatMessageRepository.findAllByUser(byUserId).get();
                dtoList = Converter.getDTOList(allMessages);

            }


            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public ResponseEntity<String> chatRasaLoginResponse(String chatMessage, String chatSessionId, String userId) {
        try {
            RasaChatMessage senderMessage = new RasaChatMessage();
            senderMessage.setSender(userId);
            senderMessage.setMessage(chatMessage);
            ResponseEntity responseEntity = this.httpService.sentHttpPostConnection(chatUrl, objectMapper.writeValueAsString(senderMessage));
            String res = responseEntity.getBody().toString();
            System.out.println("res");
            System.out.println(res);
            System.out.println("res");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }


//    @Scheduled(fixedRate = 100*3600*24)
    //    @Scheduled(cron = "0 0 0 * * *")

    public ResponseEntity generateChatModel() {
        String url = chatUrl + "generateChatModel";
        return this.httpService.sendHttpGetUrlConnection(url);

    }

    @Override
    public String itemExtractRasaDataSave(ItemExtractRasaDTO itemExtractRasaDTO) {
        itemExtractRasaDTO = RasaExtractDataFormatting.getFilteredItemExtractRasa(itemExtractRasaDTO);
        Optional<ItemExtractRasa> byId = extractRasaRepository.findAllBySessionId(itemExtractRasaDTO.getSessionId());
        if (byId.isPresent()) {
            ItemExtractRasa itemExtractRasa = byId.get();
            itemExtractRasa.setUserId(itemExtractRasaDTO.getUserId());
            itemExtractRasa.setItemCategory(itemExtractRasaDTO.getItemCategory());
            itemExtractRasa.setRam(itemExtractRasaDTO.getRam());
            itemExtractRasa.setScreen(itemExtractRasaDTO.getScreen());
            itemExtractRasa.setPrice(itemExtractRasaDTO.getPrice());
            itemExtractRasa.setBrand(itemExtractRasaDTO.getBrand());
            itemExtractRasa.setColor(itemExtractRasaDTO.getColor());
            itemExtractRasa.setStorage(itemExtractRasaDTO.getStorage());
            itemExtractRasa.setUserId(itemExtractRasaDTO.getUserId());
            extractRasaRepository.save(itemExtractRasa);
            return Integer.toString(itemExtractRasaDTO.getItemExtractId());

        } else {

            ItemExtractRasa itemExtractRasa = new ItemExtractRasa();
            itemExtractRasa.setUserId(itemExtractRasaDTO.getUserId());
            itemExtractRasa.setItemCategory(itemExtractRasaDTO.getItemCategory());
            itemExtractRasa.setRam(itemExtractRasaDTO.getRam());
            itemExtractRasa.setScreen(itemExtractRasaDTO.getScreen());
            itemExtractRasa.setPrice(itemExtractRasaDTO.getPrice());
            itemExtractRasa.setBrand(itemExtractRasaDTO.getBrand());
            itemExtractRasa.setColor(itemExtractRasaDTO.getColor());
            itemExtractRasa.setStorage(itemExtractRasaDTO.getStorage());
            itemExtractRasa.setUserId(itemExtractRasaDTO.getUserId());
            itemExtractRasa.setSessionId(itemExtractRasaDTO.getSessionId());
            ItemExtractRasa save = extractRasaRepository.save(itemExtractRasa);
            return Integer.toString(save.getItemExtractId());
        }

    }

}
