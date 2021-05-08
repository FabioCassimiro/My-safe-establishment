package br.com.mysafeestablishment.controller.user;

import br.com.mysafeestablishment.domain.user.Customer;
import br.com.mysafeestablishment.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/public/customer/register")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        return customerService.register(customer);
    }

    @PostMapping("/public/customer/login")
    public ResponseEntity<String> login(@RequestBody Customer customer) {
        return customerService.login(customer);
    }

}
