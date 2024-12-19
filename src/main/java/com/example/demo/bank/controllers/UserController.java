package com.example.demo.bank.controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bank.model.Customer;
import com.example.demo.bank.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;


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

    @GetMapping("")
    public ResponseEntity<String> loginUser(){
        return new ResponseEntity<>("login succesful",HttpStatus.ACCEPTED);
    }

    
    
}
