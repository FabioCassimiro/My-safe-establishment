package br.com.mysafeestablishment.controller.user;

import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.domain.user.Customer;
import br.com.mysafeestablishment.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin; //TODO: Verificar se a importação está correta do CrossOrigin

@CrossOrigin
@RestController
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/public/customer/register")
    public ResponseEntity<String> register(@RequestBody CustomerRequest customer) {
        return customerService.register(customer);
    }

    @PostMapping("/public/customer/login")
    public ResponseEntity<String> login(@RequestBody CustomerRequest customer) {
        return customerService.login(customer);
    }

}
