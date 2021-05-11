package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.request.CloseOrderPadRequest;
import br.com.mysafeestablishment.api.request.CreateOrderPadRequest;
import br.com.mysafeestablishment.api.request.PaymentOrderPadRequest;
import br.com.mysafeestablishment.domain.OrderPad;
import br.com.mysafeestablishment.service.OrderPadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("/private/customer/orderPad/create")
    public ResponseEntity<String> createOrderPad(@RequestBody CreateOrderPadRequest createOrderPadRequest){
        return orderPadService.createOrderPad(createOrderPadRequest);
    }

    @PostMapping("/private/customer/orderPad/close")
    public ResponseEntity<OrderPad> closeOrderPad(@RequestBody CloseOrderPadRequest closeOrderPadRequest){
        return orderPadService.closeOrderPad(closeOrderPadRequest);
    }

    @PostMapping("/private/customer/orderPad/payment")
    public ResponseEntity<String> paymentOrderPad(@RequestBody PaymentOrderPadRequest paymentOrderPadRequest){
        return orderPadService.paymentOrderPad(paymentOrderPadRequest);
    }

}
