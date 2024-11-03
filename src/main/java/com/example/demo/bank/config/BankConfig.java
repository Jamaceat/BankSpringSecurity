package com.example.demo.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BankConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/notices/**", "/login", "/error","/h2-console/**","/user/register").permitAll()
                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable()); // Deshabilitado para acceder a la consola h2
        return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user = User.withUsername("user").password("{noop}12345").authorities("read").build();
    //     UserDetails admin = User.withUsername("admin").password("{noop}12345").authorities("admin").build();

    //     return new InMemoryUserDetailsManager(user, admin);

    // }

    // @Bean
    // public PasswordEncoder passwordEncoder(){

    //     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

}
