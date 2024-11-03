package com.example.demo.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bank.model.Customer;

public interface CustomerRespository extends JpaRepository<Customer,Long>{
    
        Optional<Customer> findByEmail(String email);

}
