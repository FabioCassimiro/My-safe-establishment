package br.com.mysafeestablishment.api.client;

import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.api.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customerClient", url = "https://my-safe-establishment-company.herokuapp.com/")
public interface CustomerClient {

    @PostMapping("/public/customer/login")
    CustomerResponse customerLogin(@RequestBody CustomerRequest customerRequest);

    @PostMapping("/public/customer/register")
    CustomerResponse customerRegister(@RequestBody CustomerRequest customerRequest);

}
