package br.com.mysafeestablishment.service.user;

import br.com.mysafeestablishment.api.client.CustomerClient;
import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.domain.user.Customer;
import br.com.mysafeestablishment.exception.RegisteredUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerClient customerClient;

    @Autowired
    public CustomerService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public ResponseEntity<String> register(CustomerRequest newCustomer){
        return customerClient.customerRegister(newCustomer);
    }

    public ResponseEntity<String> login(CustomerRequest customerRequest) {
        return customerClient.customerLogin(customerRequest);
    }


}
