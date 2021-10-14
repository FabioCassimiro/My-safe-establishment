package br.com.mysafeestablishment.api.domain.repository;

import br.com.mysafeestablishment.api.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByCpf(String cpf);
}
