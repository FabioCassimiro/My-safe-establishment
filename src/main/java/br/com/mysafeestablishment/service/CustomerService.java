package br.com.mysafeestablishment.service;

import br.com.mysafeestablishment.domain.Customer;
import br.com.mysafeestablishment.exception.CustomerNotFoundException;
import br.com.mysafeestablishment.exception.RegisteredUserException;
import br.com.mysafeestablishment.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    CustomerRepository customerRepository;
    OrderPadService orderPadService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,OrderPadService orderPadService){
        this.customerRepository = customerRepository;
        this.orderPadService = orderPadService;
    }

    public Customer register(Customer newCustomer) throws RegisteredUserException {
        hasRegister(newCustomer);
        customerRepository.save(newCustomer);
        return newCustomer;
    }

    public Customer login(Customer requestCustomer) throws CustomerNotFoundException {
        Customer customer = customerRepository.findCustomerByCpfAndPhoneNumber(requestCustomer.getCpf(), requestCustomer.getPhoneNumber());
        if (customer == null){
            throw new CustomerNotFoundException("Usuario nao cadastrado");
        }

        if(orderPadService.createOrderPad(customer) == null){
          throw new CustomerNotFoundException("Erro login");
        }
        return customer;
    }

    public void hasRegister(Customer customer) throws RegisteredUserException {
        Customer customers = customerRepository.findCustomerByCpfOrPhoneNumber(customer.getCpf(), customer.getPhoneNumber());
        if (customers != null){
            throw new RegisteredUserException("Usuario ja cadastrado");
        }
    }

    public Customer hasLogin(Customer customer) throws CustomerNotFoundException {
        Customer customers = customerRepository.findCustomerByCpfAndPhoneNumber(customer.getCpf(), customer.getPhoneNumber());
        if (customers == null){
            throw new CustomerNotFoundException("Usuario nao cadastrado");
        }
        return customers;
    }

}
