package com.github.Luythen.Login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.github.Luythen.Login.Service.UserDetailService;

@Configuration
public class SecurityConfig {

    private final UserDetailService userService;

    public SecurityConfig(UserDetailService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) {
        return http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/login").permitAll()
            .requestMatchers("/auth/registre").permitAll()
            .requestMatchers("/product").permitAll()
            .requestMatchers("/product/{id}").permitAll()
            .anyRequest().authenticated()
        )
        .userDetailsService(userService)
        .formLogin(Customizer.withDefaults())
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder (String password) {
        return new BCryptPasswordEncoder();
    }

}
