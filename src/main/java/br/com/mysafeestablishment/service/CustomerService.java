package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.api.client.CustomerClient;
import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.api.response.CustomerResponse;
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

    public ResponseEntity<CustomerResponse> register(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerClient.customerRegister(customerRequest);
        if (customerResponse.getErrorMessage() == null) {
            return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(customerResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<CustomerResponse> login(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerClient.customerLogin(customerRequest);
        if (customerResponse.getErrorMessage() == null) {
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(customerResponse, HttpStatus.BAD_REQUEST);
    }

}
