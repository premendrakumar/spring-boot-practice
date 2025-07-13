package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AccountsController {
    @GetMapping("/myAccounts")
    public String welcome(){
        return "welcome to accounts";
    }
}
