package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.api.response.CustomerResponse;
import br.com.mysafeestablishment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody CustomerRequest customer) {
        return customerService.register(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerResponse> login(@RequestBody CustomerRequest customer) throws Exception {
        return customerService.login(customer);
    }

}
