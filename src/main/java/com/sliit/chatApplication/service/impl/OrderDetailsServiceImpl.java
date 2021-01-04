package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.Converter;
import com.sliit.chatApplication.model.OrderDetailsDTO;
import com.sliit.chatApplication.repository.OrderDetailsRepository;
import com.sliit.chatApplication.repository.entity.OrderDetails;
import com.sliit.chatApplication.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl() {
    }

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public OrderDetailsDTO addOrderDetail(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = orderDetailsRepository.save(Converter.getEntity(orderDetailsDTO));
        return Converter.getDTO(orderDetails);
    }

    @Override
    public List<OrderDetailsDTO> getOrderDetailList() {
        return Converter.getDTOList(orderDetailsRepository.findAll());
    }
}
