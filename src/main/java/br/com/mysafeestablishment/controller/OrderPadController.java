package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.client.MySafeEstablishmentClient;
import br.com.mysafeestablishment.api.domain.OrderPad;
import br.com.mysafeestablishment.api.request.CloseOrderPadRequest;
import br.com.mysafeestablishment.api.request.CreateOrderPadRequest;
import br.com.mysafeestablishment.api.request.PaymentOrderPadRequest;
import br.com.mysafeestablishment.api.response.CloseOrderPadResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/orderpad")
@CrossOrigin
public class OrderPadController {

    private final MySafeEstablishmentClient api;

    public OrderPadController() {
        this.api = new MySafeEstablishmentClient();
    }

    @PostMapping("/create")
    public OrderPad createOrderPad(@RequestBody CreateOrderPadRequest createOrderPadRequest) throws Exception {
        return api.createOrderPad(createOrderPadRequest);
    }

    @PostMapping("/close")
    public CloseOrderPadResponse closeOrderPad(@RequestBody CloseOrderPadRequest closeOrderPadRequest) throws Exception {
        return api.closerOrderPad(closeOrderPadRequest);
    }

    @PostMapping("/payment")
    public OrderPad paymentOrderPad(@RequestBody PaymentOrderPadRequest paymentOrderPadRequest) throws Exception {
        return api.paymentOrderPad(paymentOrderPadRequest);
    }
}
