package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.client.MySafeEstablishmentClient;
import br.com.mysafeestablishment.api.domain.Order;
import br.com.mysafeestablishment.api.domain.OrderPad;
import br.com.mysafeestablishment.api.request.PaymentOrderPadByManualRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("private/management")
@CrossOrigin
public class ManagementController {

    private final MySafeEstablishmentClient api;

    public ManagementController() {
        this.api = new MySafeEstablishmentClient();
    }


    @GetMapping("order")
    public Order orderById(@RequestParam(required = false, name = "id") Long orderId,
                           @RequestParam(required = false) Long orderpad) throws Exception {

        return api.orderById(orderId, orderpad);
    }

    @GetMapping("orders")
    public List<Order> listOrdersByOrderPad(@RequestParam(required = true) Long orderpad) throws Exception {
        return api.listOrdersByOrderPad(orderpad);
    }

    @PostMapping("change/order")
    public Order changeStatusOrder(@RequestParam(name = "id") Long orderId,
                                   @RequestParam() String status,
                                   @RequestParam(required = false) Long customerId) throws Exception {
        return api.changeStatusOrder(orderId, status, customerId);
    }

    @GetMapping("orderpad")
    public OrderPad orderpadById(@RequestParam(required = false, name = "id") Long orderPad) throws Exception {
        return api.orderpadById(orderPad);
    }

    @GetMapping("orderpads")
    public List<OrderPad> listOrderpad() throws Exception {
        return api.listOrderpad();
    }

    @PostMapping("/manual/payment/orderpad")
    public OrderPad paymentManualOrderPad(@RequestBody PaymentOrderPadByManualRequest paymentOrderPadByManualRequest) throws Exception {
        return api.paymentManualOrderPad(paymentOrderPadByManualRequest);
    }
}
