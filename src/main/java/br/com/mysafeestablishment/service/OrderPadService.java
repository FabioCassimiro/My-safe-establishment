package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.domain.OrderPad;
import br.com.mysafeestablishment.repository.OrderPadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPadService {

    OrderPadRepository orderPadRepository;

    @Autowired
    public OrderPadService(OrderPadRepository orderPadRepository){
        this.orderPadRepository = orderPadRepository;
    }

    public OrderPad register(OrderPad newOrderPad){
        orderPadRepository.save(newOrderPad);
        return newOrderPad;
    }
}

