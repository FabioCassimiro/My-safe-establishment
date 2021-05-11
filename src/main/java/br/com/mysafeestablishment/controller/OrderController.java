package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.request.OrdersRequest;
import br.com.mysafeestablishment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/private/customer/order/register")
    public ResponseEntity<String> register(@RequestBody OrdersRequest ordersRequest){
        return orderService.register(ordersRequest);
    }
}
