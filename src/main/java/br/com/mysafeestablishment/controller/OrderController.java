package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.domain.Order;
import br.com.mysafeestablishment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("order/register")
    public Order register(@RequestBody Order order){
        return orderService.register(order);
    }
}
