package com.sliit.chatApplication.controller;

import com.sliit.chatApplication.model.OrderDetailsDTO;
import com.sliit.chatApplication.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping("/addOrderDetails")
    long addOrderDetails(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        return orderDetailsService.addOrderDetail(orderDetailsDTO);
    }

    @GetMapping("/getOrderDetailsList")
    List<OrderDetailsDTO> getOrderDetailsList() {
        return orderDetailsService.getOrderDetailList();
    }


}
