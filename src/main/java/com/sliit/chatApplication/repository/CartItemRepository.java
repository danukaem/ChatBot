package com.sliit.chatApplication.repository;

import com.sliit.chatApplication.repository.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUserId(long userId);
//
//    List<CartItem> findAllByUserId(long userId);
//    List<CartItem> findByIpAddress(String ip);

    @Query(value = "select * from cart_item where user_id=? and order_detail_id is null or order_detail_id = 0", nativeQuery = true)
    List<CartItem> findAllByUserId(long userId);

    @Query(value = "select * from cart_item where ip_address=? and order_detail_id is null or order_detail_id = 0", nativeQuery = true)
    List<CartItem> findByIpAddress(String ip);

}
