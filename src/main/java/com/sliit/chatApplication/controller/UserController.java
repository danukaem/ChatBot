package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.UserDTO;
import com.sliit.chatApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/getUserList")
    List<UserDTO> getUserList() {
        return userService.getUserList();
    }


}
