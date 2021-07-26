package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.ChatMessage;
import com.sliit.chatApplication.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    Optional<ChatMessage> findByUser(User user);
    Optional<List<ChatMessage>> findAllByUser(User user);
}
