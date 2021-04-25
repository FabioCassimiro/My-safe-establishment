package br.com.mysafeestablishment.repository;

import br.com.mysafeestablishment.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {

}
