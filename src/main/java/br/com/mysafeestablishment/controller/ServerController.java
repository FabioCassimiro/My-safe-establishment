package br.com.mysafeestablishment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @GetMapping("/public/health")
    public ResponseEntity<String> serveStatus(){
        return new ResponseEntity<String>("Serve online", HttpStatus.OK);
    }
}
