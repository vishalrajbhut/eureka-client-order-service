package com.test.orderservice.service;

import com.test.orderservice.entity.Order;
import com.test.orderservice.entity.TransactionRequestResponse;
import com.test.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    RestTemplate restTemplate;

    public TransactionRequestResponse bookOrder(Order order){
        try {
            Order od = repository.save(order);
            TransactionRequestResponse request = new TransactionRequestResponse();
            request.setOrder(od);
            return processPayment(request);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private TransactionRequestResponse processPayment(TransactionRequestResponse request) {
        return restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment/", request, TransactionRequestResponse.class);
    }

    public Optional<Order> getOrderDetails(Integer orderId) {
        return repository.findById(orderId);
    }
}
