package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.UserDTO;
import com.sliit.chatApplication.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signUp")
    UserDTO signUp(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PostMapping("/signIn")
    UserDTO signIn(@RequestBody UserDTO userDTO) {
//        System.out.println(userService.signInUser(userDTO));
        return userService.signInUser(userDTO);
    }


    @GetMapping("/getUserList")
    List<UserDTO> getUserList() {
        return userService.getUserList();
    }


    @GetMapping("/getUserByUserId/{userId}")
    public UserDTO getUserByUserId(@PathVariable long userId) {

        return userService.getUserByUserId(userId);
    }

    @GetMapping("/getUserNameByUserId")
    public String getUsernameByUserId(@RequestParam("userId") String userId) {


        if (userService.getUserByUserId(Long.parseLong(userId)) != null) {

            JSONObject object = new JSONObject();
            object.put("user_name",userService.getUserByUserId(Long.parseLong(userId)).getUserName());
            object.put("session_id",userService.getUserByUserId(Long.parseLong(userId)).getSessionId());
//            System.out.println(userService.getUserByUserId(Long.parseLong(userId)).getUserName());
//            System.out.println(userService.getUserByUserId(Long.parseLong(userId)).getSessionId());
            return object.toString();
        }

        return null;
    }

}
