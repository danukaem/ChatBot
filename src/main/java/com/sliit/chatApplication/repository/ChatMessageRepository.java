package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
}
