package com.sliit.chatApplication.service;

import com.sliit.chatApplication.model.OrderDetailsDTO;

import java.util.List;

public interface OrderDetailsService {
    OrderDetailsDTO addOrderDetail(OrderDetailsDTO orderDetailsDTO);
    List<OrderDetailsDTO> getOrderDetailList();
}
