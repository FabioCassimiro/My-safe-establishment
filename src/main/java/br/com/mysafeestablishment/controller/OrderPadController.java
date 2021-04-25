package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.domain.Order;
import br.com.mysafeestablishment.domain.OrderPad;
import br.com.mysafeestablishment.service.OrderPadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPadController {

    OrderPadService orderPadService;

    @Autowired
    public OrderPadController(OrderPadService orderPadService){
        this.orderPadService = orderPadService;
    }

    @PostMapping("orderPad/register")
    public OrderPad register(@RequestBody OrderPad orderPad){
        return orderPadService.register(orderPad);
    }
}
