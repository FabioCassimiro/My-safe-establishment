package br.com.mysafeestablishment.repository;

import br.com.mysafeestablishment.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrderRepository extends CrudRepository<Order,Long> {
    ArrayList<Order> findByOrderPadId(long orderPadId);
}
