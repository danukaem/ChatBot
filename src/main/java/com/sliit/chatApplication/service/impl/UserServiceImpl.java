package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.model.SuperDTO;
import com.sliit.chatApplication.model.UserDTO;
import com.sliit.chatApplication.repository.UserRepository;
import com.sliit.chatApplication.repository.entity.User;
import com.sliit.chatApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userRepository.save(Converter.getEntity(userDTO));
        return Converter.getDTO(user);
    }

    @Override
    public UserDTO signInUser(UserDTO userDTO) {
        UserDTO user;
        List<User> userList = userRepository.findByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
        if (userList.size() > 0) {
            user = Converter.getDTO(userList.get(0));
        } else {
            user = null;
        }
        return user;
    }

    @Override
    public List<UserDTO> getUserList() {
        return Converter.getDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO getUserByUserId(long userId) {
        return Converter.getDTO(userRepository.findByUserId(userId));
    }
}
