package br.com.mysafeestablishment.controller.company;

import br.com.mysafeestablishment.api.request.RegisterCompany;
import br.com.mysafeestablishment.domain.company.Owner;
import br.com.mysafeestablishment.service.company.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/public/owner/register")
    public ResponseEntity createCompany(@RequestBody RegisterCompany registerCompany) {
        return ownerService.register(registerCompany);
    }

    @PostMapping("/public/owner/login")
    public ResponseEntity login(@RequestBody Owner owner) throws Exception {
        return ownerService.login(owner);
    }


}
