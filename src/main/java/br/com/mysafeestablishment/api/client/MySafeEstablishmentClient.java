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
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

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
    public OrderPad createOrderPad(CreateOrderPadRequest createOrderPadRequest) throws Exception {
        return getApi().createOrderPad(createOrderPadRequest);
    }

    @Override
    public CloseOrderPadResponse closerOrderPad(CloseOrderPadRequest closeOrderPadRequest) throws Exception {
        return getApi().closerOrderPad(closeOrderPadRequest);
    }

    @Override
    public OrderPad paymentOrderPad(PaymentOrderPadRequest paymentOrderPadRequest) throws Exception {
        return getApi().paymentOrderPad(paymentOrderPadRequest);
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
}
