package com.test.orderservice.controller;

import com.test.orderservice.dto.Orderdto;
import com.test.orderservice.entity.Order;
import com.test.orderservice.entity.TransactionRequestResponse;
import com.test.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping("/bookOrder/")
    public TransactionRequestResponse bookOrder(@RequestBody Orderdto order){
        return service.bookOrder(convertdtoToEntity(order));
    }

    private Order convertdtoToEntity(Orderdto dto){
        Order order = new Order(dto.getId(), dto.getName(), dto.getQty(), dto.getPrice());
        return order;
    }

    @GetMapping("/details/{orderId}")
    public Optional<Order> getOrderDetails(@PathVariable Integer orderId){
        return service.getOrderDetails(orderId);
    }
}
