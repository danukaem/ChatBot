package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.ChatMessageDTO;
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
    public List<ChatMessageDTO> getChatMessageList() {
        return chatService.getChatMessagesList();
    }


    @GetMapping("/generateChatModel")
    public ResponseEntity generateChatModel() {
        return chatService.generateChatModel();
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

