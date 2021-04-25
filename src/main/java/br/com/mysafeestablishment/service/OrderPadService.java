package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.domain.Customer;
import br.com.mysafeestablishment.domain.OrderPad;
import br.com.mysafeestablishment.repository.OrderPadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPadService {
    private final Logger logger = LoggerFactory.getLogger(OrderPadService.class);

    OrderPadRepository orderPadRepository;

    @Autowired
    public OrderPadService(OrderPadRepository orderPadRepository){
        this.orderPadRepository = orderPadRepository;
    }

    public OrderPad register(OrderPad newOrderPad){
        orderPadRepository.save(newOrderPad);
        return newOrderPad;
    }

    public OrderPad createOrderPad(Customer customer){
        OrderPad orderPad = new OrderPad();

        try{
            orderPad.setCustomerId(customer.getId());
            orderPad.setCustomerName(customer.getName());
            return orderPadRepository.save(orderPad);
        }catch (Exception e){
            logger.error("metodo='createOrderPad' - mensagem='Falha ao criar Ordem de pagamento'");
        }

        logger.info("metodo='createOrderPad' - mensagem='Ordepad Created' - Orderpad='{}'",orderPad);
        return orderPad;

    }
}

