package br.com.mysafeestablishment.controller;

import br.com.mysafeestablishment.api.domain.Owner;
import br.com.mysafeestablishment.api.request.OwnerRequest;
import br.com.mysafeestablishment.api.request.RegisterCompany;
import br.com.mysafeestablishment.api.response.OwnerResponse;
import br.com.mysafeestablishment.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public/owner")
@CrossOrigin
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/register")
    public Owner register(@RequestBody RegisterCompany registerCompany){
        return ownerService.register(registerCompany);
    }

    @PostMapping("login")
    public ResponseEntity<OwnerResponse> login (@RequestBody OwnerRequest ownerRequest) throws Exception {
        return ownerService.login(ownerRequest);
    }


}
