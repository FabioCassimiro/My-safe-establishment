package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.domain.Owner;
import br.com.mysafeestablishment.api.request.OwnerRequest;
import br.com.mysafeestablishment.api.request.RegisterCompany;
import br.com.mysafeestablishment.api.response.OwnerResponse;
import br.com.mysafeestablishment.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public/owner")
@CrossOrigin
public class OwnerController {

    private final OwnerService ownerService;
    private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/register")
    public ResponseEntity<OwnerResponse> register(@RequestBody RegisterCompany registerCompany){
        logger.info("Registrando Owner - RegisterCompany");
        return ownerService.register(registerCompany);
    }

    @PostMapping("login")
    public ResponseEntity<OwnerResponse> login (@RequestBody OwnerRequest ownerRequest) throws Exception {
        return ownerService.login(ownerRequest);
    }


}
