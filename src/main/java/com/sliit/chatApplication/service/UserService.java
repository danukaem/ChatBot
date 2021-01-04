package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    List<UserDTO> getUserList();
}
