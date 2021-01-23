package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    UserDTO signInUser(UserDTO userDTO);

    List<UserDTO> getUserList();

    UserDTO getUserByUserId(long userId);
}
