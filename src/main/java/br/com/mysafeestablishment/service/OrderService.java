package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.domain.Order;
import br.com.mysafeestablishment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order register(Order newOrder){
        orderRepository.save(newOrder);
        return newOrder;
    }
}
