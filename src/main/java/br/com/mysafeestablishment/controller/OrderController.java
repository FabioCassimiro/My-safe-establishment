package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.client.MySafeEstablishmentClient;
import br.com.mysafeestablishment.api.domain.Order;
import br.com.mysafeestablishment.api.response.MessageResponse;
import br.com.mysafeestablishment.api.response.OrdersRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/private/order")
@CrossOrigin
public class OrderController {

    private final MySafeEstablishmentClient api;

    public OrderController() {
        this.api = new MySafeEstablishmentClient();
    }

    @PostMapping("/register")
    public MessageResponse register(@RequestBody OrdersRequest ordersRequest) throws Exception {
        return api.registerOrder(ordersRequest);
    }

    @GetMapping("/{customerId}")
    public ArrayList<Order> allOrders(@PathVariable long customerId) throws Exception {
        return api.allOrdersByCustomerId(customerId);
    }

    @GetMapping("/{customerId}/{orderId}")
    public Order orderById(@PathVariable long customerId, @PathVariable long orderId) throws Exception {
        return api.ordersByCustomerId(customerId, orderId);
    }

    @DeleteMapping("delete/order")
    public MessageResponse deleteOrder(@RequestParam(name = "id") Long orderId, @RequestParam Long orderpadId) throws Exception {
        return api.deleteOrder(orderId, orderpadId);
    }

    @PostMapping("update/{orderId}/{orderpadId}/{quantity}")
    public Order update(@PathVariable long orderId, @PathVariable long orderpadId, @PathVariable int quantity) throws Exception {
        return api.updateOrder(orderId, orderpadId, quantity);
    }
}
