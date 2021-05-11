package br.com.mysafeestablishment.repository.user;

import br.com.mysafeestablishment.domain.user.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Customer findCustomerByCpfOrPhoneNumber(String cpf, String phoneNumber);

    Customer findCustomerByCpfAndPhoneNumber(String cpf, String phoneNumber);

    Customer findById(long id);



}
