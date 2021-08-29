package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.api.client.CustomerClient;
import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.api.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerClient customerClient;

    @Autowired
    public CustomerService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public ResponseEntity<CustomerResponse> register(CustomerRequest customerRequest) {
        return customerClient.customerRegister(customerRequest);
    }

    public ResponseEntity<CustomerResponse> login(CustomerRequest customerRequest) {
        return customerClient.customerLogin(customerRequest);
    }

}
