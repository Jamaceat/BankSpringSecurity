package com.example.demo.bank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/balance")
public class BalanceController {


    @GetMapping("/")
    public String getBalance() {
        return "Here is the information about the balance";
    }
    

    
}
