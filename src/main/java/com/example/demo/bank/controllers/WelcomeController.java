package com.example.demo.bank.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Value("${NAME:World}")
    String name;

    @GetMapping("")
    String hello() {
        return "Hello " + name + "!";
    }

}
