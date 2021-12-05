package br.com.mysafeestablishment.api.client;

import br.com.mysafeestablishment.api.domain.Order;
import br.com.mysafeestablishment.api.domain.OrderPad;
import br.com.mysafeestablishment.api.domain.Product;
import br.com.mysafeestablishment.api.domain.TableEstablishment;
import br.com.mysafeestablishment.api.request.*;
import br.com.mysafeestablishment.api.response.CloseOrderPadResponse;
import br.com.mysafeestablishment.api.response.MessageResponse;
import br.com.mysafeestablishment.api.response.OrdersRequest;
import feign.Feign;
import feign.Logger;
import feign.Param;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MySafeEstablishmentClient implements MySafeEstablismentApi {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MySafeEstablishmentClient.class);

    private static class CustomLogger extends Logger {
        @Override
        protected void log(String s, String s1, Object... objects) {
            logger.info(String.format(s.concat(" - ") + s1 + "%n", objects));
        }
    }

    public Feign.Builder getBuilder() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new CustomLogger())
                .logLevel(Logger.Level.FULL)
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
    public Product registerProduct(CreateProductRequest product) throws Exception {
        return getApi().registerProduct(product);
    }

    @Override
    public MessageResponse delectProduct(Long id) throws Exception {
        return getApi().delectProduct(id);
    }

    @Override
    public Product updateProduct(Product product) throws Exception {
        return getApi().updateProduct(product);
    }

    @Override
    public MessageResponse registerOrder(OrdersRequest ordersRequest) throws Exception {
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
    public MessageResponse deleteOrder(Long orderId, Long orderpadId) throws Exception {
        return getApi().deleteOrder(orderId, orderpadId);
    }

    @Override
    public Order updateOrder(long orderId, long orderpadId, int quantity) throws Exception {
        return getApi().updateOrder(orderId, orderpadId, quantity);
    }

    @Override
    public OrderPad createOrderPad(CreateOrderPadRequest createOrderPadRequest) throws Exception {
        return getApi().createOrderPad(createOrderPadRequest);
    }

    @Override
    public CloseOrderPadResponse closerOrderPad(CloseOrderPadRequest closeOrderPadRequest) throws Exception {
        return getApi().closerOrderPad(closeOrderPadRequest);
    }

    @Override
    public OrderPad paymentOrderPad(long orderpadId, long customerId) throws Exception {
        return getApi().paymentOrderPad(orderpadId, customerId);
    }

    @Override
    public OrderPad paymentOrderPadbyCard(PaymentOrderPadByCardRequest paymentOrderPadByCardRequest) throws Exception {
        return getApi().paymentOrderPadbyCard(paymentOrderPadByCardRequest);
    }

    @Override
    public OrderPad orderPadByIdAndCustomerId(long orderpadId, long customerId) throws Exception {
        return getApi().orderPadByIdAndCustomerId(orderpadId, customerId);
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
    public MessageResponse delectTable(Long id) throws Exception {
        return getApi().delectTable(id);
    }

    @Override
    public TableEstablishment updateTable(TableEstablishment table) throws Exception {
        return getApi().updateTable(table);
    }

    @Override
    public List<TableEstablishment> tableByNumberSeats(Integer numberSeats) throws Exception {
        return getApi().tableByNumberSeats(numberSeats);
    }

    @Override
    public Order orderById(Long orderId, Long orderpad) throws Exception {
        return getApi().orderById(orderId, orderpad);
    }

    @Override
    public List<Order> listOrdersByOrderPad(Long orderpad) throws Exception {
        return getApi().listOrdersByOrderPad(orderpad);
    }

    @Override
    public Order changeStatusOrder(Long orderId, String status, Long customerId) throws Exception {
        return getApi().changeStatusOrder(orderId, status, customerId);
    }

    @Override
    public OrderPad orderpadById(Long id) throws Exception {
        return getApi().orderpadById(id);
    }

    @Override
    public List<OrderPad> listOrderpad() throws Exception {
        return getApi().listOrderpad();
    }

    @Override
    public OrderPad paymentManualOrderPad(PaymentOrderPadByManualRequest paymentOrderPadByManualRequest) throws Exception {
        return getApi().paymentManualOrderPad(paymentOrderPadByManualRequest);
    }
}
