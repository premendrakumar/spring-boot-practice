package com.spp.demo.helloworld.welcome;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

    @GetMapping("")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<String>("Hello Spring Boot",HttpStatusCode.valueOf(200));
    }
}
