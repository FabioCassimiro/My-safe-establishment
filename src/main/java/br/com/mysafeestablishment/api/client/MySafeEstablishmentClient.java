package br.com.mysafeestablishment.api.client;

import br.com.mysafeestablishment.api.domain.Order;
import br.com.mysafeestablishment.api.domain.OrderPad;
import br.com.mysafeestablishment.api.domain.Product;
import br.com.mysafeestablishment.api.domain.TableEstablishment;
import br.com.mysafeestablishment.api.request.CloseOrderPadRequest;
import br.com.mysafeestablishment.api.request.CreateOrderPadRequest;
import br.com.mysafeestablishment.api.request.PaymentOrderPadRequest;
import br.com.mysafeestablishment.api.response.CloseOrderPadResponse;
import br.com.mysafeestablishment.api.response.OrdersRequest;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.ArrayList;

public class MySafeEstablishmentClient implements MySafeEstablismentApi {

    public Feign.Builder getBuilder() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new CustomErrorDecoder());
    }

    private MySafeEstablismentApi getApi() {
        return this.getBuilder().target(MySafeEstablismentApi.class, "https://my-safe-establishment-company.herokuapp.com");
    }

    @Override
    public ArrayList<Product> allProducts() throws Exception {
        return getApi().allProducts();
    }

    @Override
    public Product productById(Long id) throws Exception {
        return this.getApi().productById(id);
    }

    @Override
    public Product registerProduct(Product product) throws Exception {
        return getApi().registerProduct(product);
    }

    @Override
    public String delectProduct(Long id) throws Exception {
        return getApi().delectProduct(id);
    }

    @Override
    public Product updateProduct(Product product) throws Exception {
        return getApi().registerProduct(product);
    }

    @Override
    public String registerOrder(OrdersRequest ordersRequest) throws Exception {
        return getApi().registerOrder(ordersRequest);
    }

    @Override
    public ArrayList<Order> allOrdersByCustomerId(Long customerId) throws Exception {
        return getApi().allOrdersByCustomerId(customerId);
    }

    @Override
    public Order ordersByCustomerId(Long customerId, Long orderId) throws Exception {
        return getApi().ordersByCustomerId(customerId, orderId);
    }

    @Override
    public OrderPad createOrderPad(CreateOrderPadRequest createOrderPadRequest) throws Exception {
        return getApi().createOrderPad(createOrderPadRequest);
    }

    @Override
    public CloseOrderPadResponse closerOrderPad(CloseOrderPadRequest closeOrderPadRequest) {
        return getApi().closerOrderPad(closeOrderPadRequest);
    }

    @Override
    public OrderPad paymentOrderPad(PaymentOrderPadRequest paymentOrderPadRequest) {
        return getApi().paymentOrderPad(paymentOrderPadRequest);
    }

    @Override
    public ArrayList<TableEstablishment> allTables() throws Exception {
        return getApi().allTables();
    }

    @Override
    public TableEstablishment tableById(Long id) throws Exception {
        return getApi().tableById(id);
    }

    @Override
    public TableEstablishment registerTable(TableEstablishment table) throws Exception {
        return getApi().registerTable(table);
    }

    @Override
    public String delectTable(Long id) throws Exception {
        return getApi().delectTable(id);
    }

    @Override
    public String updateTable(TableEstablishment table) throws Exception {
        return getApi().updateTable(table);
    }
}
