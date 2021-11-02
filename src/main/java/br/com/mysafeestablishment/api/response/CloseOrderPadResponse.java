package br.com.mysafeestablishment.api.response;

import br.com.mysafeestablishment.api.domain.Order;
import br.com.mysafeestablishment.api.domain.OrderPad;

import java.util.ArrayList;

public class CloseOrderPadResponse {

    private OrderPad orderPad;
    private ArrayList<Order> orders;

    public CloseOrderPadResponse() {
    }

    public OrderPad getOrderPad() {
        return orderPad;
    }

    public void setOrderPad(OrderPad orderPad) {
        this.orderPad = orderPad;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public CloseOrderPadResponse(OrderPad orderPad, ArrayList<Order> orders) {
        this.orderPad = orderPad;
        this.orders = orders;
    }
}
