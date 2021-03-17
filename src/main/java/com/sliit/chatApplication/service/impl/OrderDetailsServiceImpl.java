package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.model.OrderDetailsDTO;
import com.sliit.chatApplication.repository.CartItemRepository;
import com.sliit.chatApplication.repository.OrderDetailsRepository;
import com.sliit.chatApplication.repository.entity.CartItem;
import com.sliit.chatApplication.repository.entity.OrderDetails;
import com.sliit.chatApplication.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    OrderDetailsRepository orderDetailsRepository;
    CartItemRepository cartItemRepository;

    public OrderDetailsServiceImpl() {
    }

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, CartItemRepository cartItemRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public long addOrderDetail(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = orderDetailsRepository.save(Converter.getEntity(orderDetailsDTO));

        orderDetailsDTO.getCartItems().forEach(cartItem -> {
            if (cartItem.getOrderDetails() == null) {
                cartItem.setOrderDetails(orderDetails);
                CartItem save = cartItemRepository.save(cartItem);
            }
        });
        return orderDetails.getOrderId();

    }

    @Override
    public long removeOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = orderDetailsRepository.save(Converter.getEntity(orderDetailsDTO));

        orderDetailsDTO.getCartItems().forEach(cartItem -> {
            if (cartItem.getOrderDetails() == null) {
                cartItem.setOrderDetails(orderDetails);
                CartItem save = cartItemRepository.save(cartItem);
            }
        });
        return orderDetails.getOrderId();
    }

    @Override
    public List<OrderDetailsDTO> getOrderDetailList() {
        return Converter.getDTOList(orderDetailsRepository.findAll());
    }
}
