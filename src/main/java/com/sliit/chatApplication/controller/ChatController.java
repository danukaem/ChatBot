package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.ChatMessageDTO;
import com.sliit.chatApplication.model.ItemExtractRasaDTO;
import com.sliit.chatApplication.model.StateOfOrder;
import com.sliit.chatApplication.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Object getChatMessageList(@RequestParam("userId") String userId) {
        return chatService.getChatMessagesList(userId);
    }


    @GetMapping("/chat")
    public Object getChatResponse(@RequestParam("chatMessage") String chatMessage, @RequestParam("chatSessionId") String chatSessionId
            , @RequestParam("userId") String userId) {
        return chatService.getChatResponse(chatMessage, chatSessionId, userId);
    }

    @GetMapping("/chatLoginRasa")
    public Object chatRasaLoginResponse(@RequestParam("chatMessage") String chatMessage, @RequestParam("chatSessionId") String chatSessionId
            , @RequestParam("userId") String userId) {
        System.out.println(chatMessage);
        return chatService.chatRasaLoginResponse(chatMessage, chatSessionId, userId);
    }

    @GetMapping("/generateChatModel")
    public ResponseEntity generateChatModel() {
        return chatService.generateChatModel();
    }

    @GetMapping("/itemExtractRasaDataSave")
    public String itemExtractRasaDataSave(@RequestParam("item") String item, @RequestParam("ram") String ram
            , @RequestParam("screen") String screen, @RequestParam("price") String price
            , @RequestParam("brand") String brand, @RequestParam("color") String color
            , @RequestParam("storage") String storage, @RequestParam("user_id") String user_id
            , @RequestParam("item_extract_id") String itemExtractId
            , @RequestParam("session_id") String sessionId) {

        ItemExtractRasaDTO itemExtractRasaDTO = new ItemExtractRasaDTO();
        itemExtractRasaDTO.setItemCategory(item);
        itemExtractRasaDTO.setRam(ram);
        itemExtractRasaDTO.setScreen(screen);
        itemExtractRasaDTO.setPrice(price);
        itemExtractRasaDTO.setBrand(brand);
        itemExtractRasaDTO.setColor(color);
        itemExtractRasaDTO.setStorage(storage);
        itemExtractRasaDTO.setSessionId(sessionId);
        try {
            itemExtractRasaDTO.setUserId(Integer.parseInt(user_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!itemExtractId.trim().equals("")) {
            try {
                itemExtractRasaDTO.setItemExtractId(Integer.parseInt(itemExtractId));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(itemExtractRasaDTO);

        return chatService.itemExtractRasaDataSave(itemExtractRasaDTO);
    }


//    @GetMapping("/testEndPoint")
//    public String testGetEndPoint(@RequestParam("user_name") String userName, @RequestParam("user_id") String userId) {
////        System.out.println(userId);
////        System.out.println(userName);
////        User user = new User(Long.parseLong("1"), "Danuka", "danuka@gmail.com", "1234", UserDTO.Gender.MALE, new Date(), "sri lanka", "maharagama", Float.parseFloat("30"));
//
//        JSONObject object = new JSONObject();
//        JSONObject addressObject = new JSONObject();
//        addressObject.put("no",160);
//        addressObject.put("city","Colombo");
//        addressObject.put("country","Sri Lanka");
//        object.put("name",userName);
//        object.put("id",userId);
//        object.put("address",addressObject);
//
//
//        return object.toString();
//
//
//    }

//    @PostMapping("/testPostEndPoint")
//    public TestUser testPostEndPoint(@RequestBody TestUser user) {
//
//
//        System.out.println(user.getAddress().getCountry());
//        System.out.println(user.getAddress().getCity());
//        user.setName("DANUKA ERANDA MALAWANA");
//        user.getAddress().setCountry("SRI LANKA");
//        return user;
//
//
//    }

}

//@Data
//class TestUser{
//    String name;
//    String id;
//    TestAddress address;
//}
//
//@Data
//class TestAddress{
//    int no;
//    String city;
//    String country;
//}

