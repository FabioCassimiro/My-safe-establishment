package br.com.mysafeestablishment.api.client;

import br.com.mysafeestablishment.api.domain.OrderPad;
import br.com.mysafeestablishment.api.domain.Product;
import br.com.mysafeestablishment.api.domain.TableEstablishment;
import br.com.mysafeestablishment.api.request.CloseOrderPadRequest;
import br.com.mysafeestablishment.api.request.CreateOrderPadRequest;
import br.com.mysafeestablishment.api.request.PaymentOrderPadRequest;
import br.com.mysafeestablishment.api.response.CloseOrderPadResponse;
import br.com.mysafeestablishment.api.domain.Order;
import br.com.mysafeestablishment.api.response.MessageResponse;
import br.com.mysafeestablishment.api.response.OrdersRequest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
@Headers("Content-Type: application/json")

public interface MySafeEstablismentApi {

    /* Product */

    @RequestLine("GET /private/owner/products")
    ArrayList<Product> allProducts() throws Exception;

    @RequestLine("GET /private/owner/product/{id}")
    Product productById(@Param("id") Long id) throws Exception;

    @RequestLine("POST /private/owner/product/register")
    Product registerProduct(@RequestBody Product product) throws Exception;

    @RequestLine("DELETE /private/owner/product/delete/{id}")
    MessageResponse delectProduct(@Param("id") Long id) throws Exception;

    @RequestLine("PUT /private/owner/product/update")
    Product updateProduct(@RequestBody Product product) throws Exception;

    /* Order */

    @RequestLine("POST /private/order/register")
    MessageResponse registerOrder(@RequestBody OrdersRequest ordersRequest) throws Exception;

    @RequestLine("GET /private/order/{customerId}")
    ArrayList<Order> allOrdersByCustomerId(@Param("customerId") Long customerId) throws Exception;

    @RequestLine("GET /private/order/{customerId}/{orderId}")
    Order ordersByCustomerId(@Param("customerId") Long customerId, @Param("customerId") Long orderId) throws Exception;

    /* OrderPad */

    @RequestLine("POST /private/orderpad/create")
    OrderPad createOrderPad(@RequestBody CreateOrderPadRequest createOrderPadRequest) throws Exception;

    @RequestLine("POST /private/orderpad/close")
    CloseOrderPadResponse closerOrderPad(@RequestBody CloseOrderPadRequest closeOrderPadRequest) throws Exception;

    @RequestLine("POST /private/orderpad/payment")
    OrderPad paymentOrderPad(@RequestBody PaymentOrderPadRequest paymentOrderPadRequest) throws Exception;

    /* Tables */

    @RequestLine("GET /private/owner/tables")
    ArrayList<TableEstablishment> allTables() throws Exception;

    @RequestLine("GET /private/owner/table/{id}")
    TableEstablishment tableById(@Param("id") Long id) throws Exception;

    @RequestLine("POST /private/owner/table/register")
    TableEstablishment registerTable(@RequestBody TableEstablishment table) throws Exception;

    @RequestLine("DELETE /private/owner/table/delete/{id}")
    MessageResponse delectTable(@Param("id") Long id) throws Exception;

    @RequestLine("PUT /private/owner/table/update")
    TableEstablishment updateTable(@RequestBody TableEstablishment table) throws Exception;
}
