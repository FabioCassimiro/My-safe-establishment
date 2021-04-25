package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.domain.Customer;
import br.com.mysafeestablishment.exception.CustomerNotFoundException;
import br.com.mysafeestablishment.exception.RegisteredUserException;
import br.com.mysafeestablishment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) throws RegisteredUserException {
        return customerService.register(customer);
    }

    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer) throws CustomerNotFoundException {
        return customerService.login(customer);
    }

}
