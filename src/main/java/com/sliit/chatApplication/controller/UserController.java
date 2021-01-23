package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.UserDTO;
import com.sliit.chatApplication.service.UserService;
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
        System.out.println(userService.signInUser(userDTO));
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

}
