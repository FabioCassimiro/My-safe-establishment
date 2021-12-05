package br.com.mysafeestablishment.service;


import br.com.mysafeestablishment.api.domain.Address;
import br.com.mysafeestablishment.api.domain.Customer;
import br.com.mysafeestablishment.api.domain.Establishment;
import br.com.mysafeestablishment.api.domain.Owner;
import br.com.mysafeestablishment.api.domain.repository.AddressRepository;
import br.com.mysafeestablishment.api.domain.repository.CustomerRepository;
import br.com.mysafeestablishment.api.domain.repository.EstablishmentRepository;
import br.com.mysafeestablishment.api.domain.repository.OwnerRepository;
import br.com.mysafeestablishment.api.request.OwnerRequest;
import br.com.mysafeestablishment.api.request.RegisterCompany;
import br.com.mysafeestablishment.api.response.OwnerResponse;
import br.com.mysafeestablishment.security.service.UserDetailsServiceImpl;
import br.com.mysafeestablishment.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class);

    private final OwnerRepository ownerRepository;
    private final EstablishmentRepository establishmentRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final JWTUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, EstablishmentRepository establishmentRepository, AddressRepository addressRepository, CustomerRepository customerRepository, JWTUtils jwtUtils, UserDetailsServiceImpl userDetailsService, AuthenticationManager authenticationManager) {
        this.ownerRepository = ownerRepository;
        this.establishmentRepository = establishmentRepository;
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    public ResponseEntity<OwnerResponse> register(RegisterCompany newCompany) {
        Address address = addressRepository.save(newCompany.getAddress());
        logger.info("Endereço Registrado - Address='{}'", address);
        Establishment establishment = newCompany.getEstablishment();
        establishment.setAddress(address);
        establishment = establishmentRepository.save(newCompany.getEstablishment());
        logger.info("Estabelecimento Registrado - Establishment='{}'", establishment);
        Owner owner = newCompany.getOwner();
        owner.setEstablishment(establishment);
        owner = ownerRepository.save(owner);
        logger.info("Proprietario Registrado - Owner='{}'", owner);
        Customer customer = customerRepository.save(
                new Customer(
                        owner.getName(),
                        owner.getPassword(),
                        owner.getEmail(),
                        "OWNER_ROLE"
                )
        );
        logger.info("Cadastrado com sucesso");
        return new ResponseEntity<>(new OwnerResponse(
                customer.getId(),
                customer.getName(),
                authenticateUser(new OwnerRequest(owner.getEmail(), owner.getPassword()))
        ), HttpStatus.OK);
    }

    public ResponseEntity<OwnerResponse> login(OwnerRequest ownerRequest) throws Exception {
        try {
            String token = authenticateUser(ownerRequest);
            Customer customer = customerRepository.findByCpf(ownerRequest.getEmail());
            if (!customer.getRole().equals("OWNER_ROLE")){
                throw new Exception("Não permitido");
            }
            return new ResponseEntity<>(new OwnerResponse(
                    customer.getId(),
                    customer.getName(),
                    token
            ), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Não foi possivel autenticar usuario - erro='{}'", e.getMessage());
            throw e;
        }
    }

    private String authenticateUser(OwnerRequest ownerRequest) throws BadCredentialsException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        ownerRequest.getEmail(),
                        ownerRequest.getPassword())
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(ownerRequest.getEmail());
        return jwtUtils.generateToken(userDetails);
    }


}
