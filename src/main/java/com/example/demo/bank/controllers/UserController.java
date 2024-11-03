package com.example.demo.bank.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bank.model.Customer;
import com.example.demo.bank.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<String> registerUserEntity(@RequestBody Customer customer) {
        
        String hashPwd=passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashPwd);

        customer=customerRepository.save(customer);

        if(customer.getId()>0) return new ResponseEntity<String>("User created",HttpStatus.CREATED);


        return new ResponseEntity<String>("User not created",HttpStatus.BAD_REQUEST);
    }
    
    
}
