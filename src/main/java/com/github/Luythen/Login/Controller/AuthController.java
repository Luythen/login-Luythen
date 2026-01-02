package com.github.Luythen.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.Luythen.Login.Model.RegisterDto;
import com.github.Luythen.Login.Service.AuthService;
import com.github.Luythen.Login.Service.RegisterService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    RegisterService registerService;

    @Autowired
    private AuthService authService;

    @GetMapping("/register")
    public String regisString(Model model) {
        if (authService.isAuthenticated()) {
            return "redirect:/";
        }

        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String regAndView(@ModelAttribute("user") RegisterDto user, HttpServletRequest request, Errors errors) {
        if (authService.isAuthenticated()) {
            return "redirect:/";
        }
        try {
            registerService.registerNewUserAccount(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "register";
        }
            
        return "redirect:/auth/login";
    }
    
    @GetMapping("/login")
    public String login() {
        if (authService.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }
    
}
