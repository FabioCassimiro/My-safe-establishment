package br.com.mysafeestablishment.api.client;

import br.com.mysafeestablishment.api.request.CustomerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customerClient", url = "https://msec-dev.herokuapp.com/")
public interface CustomerClient {

    @PostMapping("/public/customer/login")
    ResponseEntity<String> customerLogin(@RequestBody CustomerRequest customerRequest);

    @PostMapping("/public/customer/register")
    ResponseEntity<String> customerRegister(@RequestBody CustomerRequest customerRequest);

}
