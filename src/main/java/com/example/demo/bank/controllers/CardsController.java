package com.example.demo.bank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class CardsController {

    @GetMapping("")
    public String getCard() {
        return "Here is the Card information";
    }

}
