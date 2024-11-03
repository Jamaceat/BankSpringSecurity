package com.example.demo.bank.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.bank.model.Customer;
import com.example.demo.bank.repository.CustomerRespository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BankUserDetailsService implements UserDetailsService{

private final CustomerRespository customerRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer=customerRespository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException(username));
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getEmail(),customer.getPwd(),authorities);
    }
    
}
