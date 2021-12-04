package br.com.mysafeestablishment.api.client;

import br.com.mysafeestablishment.api.domain.Order;
import br.com.mysafeestablishment.api.domain.OrderPad;
import br.com.mysafeestablishment.api.domain.Product;
import br.com.mysafeestablishment.api.domain.TableEstablishment;
import br.com.mysafeestablishment.api.request.*;
import br.com.mysafeestablishment.api.response.CloseOrderPadResponse;
import br.com.mysafeestablishment.api.response.MessageResponse;
import br.com.mysafeestablishment.api.response.OrdersRequest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Headers("Content-Type: application/json")

public interface MySafeEstablismentApi {

    /* Product */

    @RequestLine("GET /private/products")
    ArrayList<Product> allProducts() throws Exception;

    @RequestLine("GET /private/product/{id}")
    Product productById(@Param("id") Long id) throws Exception;

    @RequestLine("POST /private/product/register")
    Product registerProduct(@RequestBody CreateProductRequest product) throws Exception;

    @RequestLine("DELETE /private/product/delete/{id}")
    MessageResponse delectProduct(@Param("id") Long id) throws Exception;

    @RequestLine("PUT /private/product/update")
    Product updateProduct(@RequestBody Product product) throws Exception;

    /* Order */

    @RequestLine("POST /private/order/register")
    MessageResponse registerOrder(@RequestBody OrdersRequest ordersRequest) throws Exception;

    @RequestLine("GET /private/order/{customerId}")
    ArrayList<Order> allOrdersByCustomerId(@Param("customerId") Long customerId) throws Exception;

    @RequestLine("GET /private/order/{customerId}/{orderId}")
    Order ordersByCustomerId(@Param("customerId") Long customerId, @Param("orderId") Long orderId) throws Exception;

    @RequestLine("DELETE /private/order/delete")
    MessageResponse deleteOrder(@RequestBody Order order) throws Exception;

    /* OrderPad */

    @RequestLine("POST /private/orderpad/create")
    OrderPad createOrderPad(@RequestBody CreateOrderPadRequest createOrderPadRequest) throws Exception;

    @RequestLine("POST /private/orderpad/close")
    CloseOrderPadResponse closerOrderPad(@RequestBody CloseOrderPadRequest closeOrderPadRequest) throws Exception;

    @RequestLine("POST /manual/payment/{ordepadId}/{customerId}")
    OrderPad paymentOrderPad(@Param("orderpadId") long orderpadId, @Param("customerId") long customerId) throws Exception;

    @RequestLine("POST /private/orderpad/card/payment")
    OrderPad paymentOrderPadbyCard(@RequestBody PaymentOrderPadByCardRequest paymentOrderPadByCardRequest) throws Exception;

    @RequestLine("GET /private/orderpad/{orderpadId}/{customerId}")
    OrderPad orderPadByIdAndCustomerId(@Param("orderpadId") long orderpadId, @Param("customerId") long customerId) throws Exception;

    /* Tables */

    @RequestLine("GET /private/tables")
    ArrayList<TableEstablishment> allTables() throws Exception;

    @RequestLine("GET /private/table/{id}")
    TableEstablishment tableById(@Param("id") Long id) throws Exception;

    @RequestLine("POST /private/table/register")
    TableEstablishment registerTable(@RequestBody TableEstablishment table) throws Exception;

    @RequestLine("DELETE /private/table/delete/{id}")
    MessageResponse delectTable(@Param("id") Long id) throws Exception;

    @RequestLine("PUT /private/table/update")
    TableEstablishment updateTable(@RequestBody TableEstablishment table) throws Exception;

    @RequestLine("GET /private/table")
    List<TableEstablishment> tableByNumberSeats(@Param Integer numberSeats) throws Exception;

    /* Management */

    @RequestLine("GET private/management/order")
    Order orderById(@Param Long orderId, @Param Long orderpad) throws Exception;

    @RequestLine("GET private/management/orders")
    List<Order> listOrdersByOrderPad(@Param Long orderpad) throws Exception;

    @RequestLine("POST private/management/change/order")
    Order changeStatusOrder(@Param Long orderId, @Param String status, @Param Long customerId) throws Exception;

    @RequestLine("POST private/management/orderpad")
    OrderPad orderpadById(@Param Long id) throws Exception;

    @RequestLine("GET private/management/orderpads")
    List<OrderPad> listOrderpad() throws Exception;

    @RequestLine("POST private/management/manual/payment/orderpad")
    OrderPad paymentManualOrderPad(@RequestBody PaymentOrderPadByManualRequest paymentOrderPadByManualRequest) throws Exception;

}
