package br.com.mysafeestablishment.security.service;

import br.com.mysafeestablishment.api.domain.Customer;
import br.com.mysafeestablishment.api.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Autowired
    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByCpf(s);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer não encontrado");
        }
        return new User(customer.getUsername(), customer.getPassword(), new ArrayList<>());
    }
}
