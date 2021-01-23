package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUserId(long userId);
    List<CartItem> findByIpAddress(String ip);
}
