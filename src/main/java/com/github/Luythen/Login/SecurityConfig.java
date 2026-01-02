package com.github.Luythen.Login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.github.Luythen.Login.Service.UserDetailServiceImpl;

@Configuration
public class SecurityConfig {

    private final UserDetailServiceImpl userService;

    public SecurityConfig(UserDetailServiceImpl userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) {
        return http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/login").permitAll()
            .requestMatchers("/auth/register").permitAll()
            .requestMatchers("/logout").authenticated()
            .requestMatchers("/").permitAll()
            .requestMatchers("/product/{id}").permitAll()
            .requestMatchers("/product/add").hasRole("Admin")
            .requestMatchers("/Img/**").permitAll()
            .anyRequest().authenticated()
        )
        .userDetailsService(userService)
        .formLogin(loginForm -> {
            loginForm.loginPage("/auth/login");
            loginForm.defaultSuccessUrl("/", true);
        })
        .logout(logout -> {
            logout.logoutUrl("/logout");
            logout.logoutSuccessUrl("/logout.done");
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.clearAuthentication(true);
            logout.permitAll();
        })
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

}
