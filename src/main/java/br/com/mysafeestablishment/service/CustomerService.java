package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.utils.JWTUtils;
import br.com.mysafeestablishment.api.client.CustomerClient;
import br.com.mysafeestablishment.api.domain.Customer;
import br.com.mysafeestablishment.api.domain.repository.CustomerRepository;
import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.api.response.CustomerResponse;
import br.com.mysafeestablishment.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    CustomerClient customerClient;
    CustomerRepository customerRepository;

    public CustomerService(CustomerClient customerClient, CustomerRepository customerRepository) {
        this.customerClient = customerClient;
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<CustomerResponse> register(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerClient.customerRegister(customerRequest);
        if (customerResponse.getErrorMessage() == null) {
            return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(customerResponse, HttpStatus.BAD_REQUEST);
    }

//    public ResponseEntity<CustomerResponse> login(CustomerRequest customerRequest) {
//        CustomerResponse customerResponse = customerClient.customerLogin(customerRequest);
//        if (customerResponse.getErrorMessage() == null) {
//            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(customerResponse, HttpStatus.BAD_REQUEST);
//    }

    public ResponseEntity<CustomerResponse> login(CustomerRequest customerRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            customerRequest.getCpf(),
                            customerRequest.getPhoneNumber())

            );
        } catch (BadCredentialsException e){
            return new ResponseEntity<>(new CustomerResponse("Erro ao altendicar"),HttpStatus.BAD_REQUEST);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(customerRequest.getCpf());
        Customer customer = customerRepository.findByCpf(customerRequest.getCpf());

        final String token = jwtUtils.generateToken(userDetails);


        return new ResponseEntity<>(new CustomerResponse(
                customer.getName(),
                customer.getId(),
                token
        ),HttpStatus.OK);
    }

}
