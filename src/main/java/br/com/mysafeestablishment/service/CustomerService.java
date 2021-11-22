package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.api.client.MySafeEstablishmentClient;
import br.com.mysafeestablishment.api.domain.Customer;
import br.com.mysafeestablishment.api.domain.repository.CustomerRepository;
import br.com.mysafeestablishment.api.request.CustomerRequest;
import br.com.mysafeestablishment.api.response.CustomerResponse;
import br.com.mysafeestablishment.security.service.UserDetailsServiceImpl;
import br.com.mysafeestablishment.utils.CustomerUtils;
import br.com.mysafeestablishment.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final CustomerRepository customerRepository;

    public CustomerService(JWTUtils jwtUtils,
                           AuthenticationManager authenticationManager,
                           UserDetailsServiceImpl userDetailsService,
                           CustomerRepository customerRepository) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<CustomerResponse> register(CustomerRequest customerRequest) throws Exception {
        hasRegister(customerRequest);
        CustomerResponse customerResponse = saveCustomer(customerRequest);
        logger.info("Customer criado com sucesso - CustomerResponse='{}'", customerResponse);
        customerResponse.setToken(authenticateUser(customerRequest));
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    public void hasRegister(CustomerRequest customerRequest) throws Exception {
        logger.info("Verificando se customer ja existe na base");
        if (customerRepository.existsByCpfOrPhoneNumber(customerRequest.getCpf(), customerRequest.getPhoneNumber())) {
            logger.info("customer ja existe na base - Customer='{}'", customerRequest.getCpf());
            throw new Exception("Customer ja cadastrado");
        }
    }

    public CustomerResponse saveCustomer(CustomerRequest customerRequest) throws Exception {
        Customer customer = customerRepository.save(
                new Customer(
                        customerRequest.getName(),
                        CustomerUtils.validatePhoneNumber(customerRequest.getPhoneNumber()),
                        CustomerUtils.validateCpf(customerRequest.getCpf()),
                        "CUSTOMER_ROLE"
                ));
        if (Objects.isNull(customer.getId())) {
            throw new Exception("Não foi possivel criar o customer");
        }
        logger.info("Customer criado com sucesso - Customer='{}'", customerRequest.getCpf());
        return new CustomerResponse(customer.getName(), customer.getId(), null);
    }

    public ResponseEntity<CustomerResponse> login(CustomerRequest customerRequest) throws Exception{
        try {
            String token = authenticateUser(customerRequest);
            Customer customer = customerRepository.findByCpf(customerRequest.getCpf());
            return new ResponseEntity<>(new CustomerResponse(
                    customer.getName(),
                    customer.getId(),
                    token
            ), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Não foi possivel autenticar usuario - erro='{}'", e.getMessage());
            throw e;
        }
    }

    private String authenticateUser(CustomerRequest customerRequest) throws BadCredentialsException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        customerRequest.getCpf(),
                        customerRequest.getPhoneNumber())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(customerRequest.getCpf());
        return jwtUtils.generateToken(userDetails);
    }

}
