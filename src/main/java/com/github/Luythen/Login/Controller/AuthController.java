package com.github.Luythen.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.Luythen.Login.Model.RegisterDto;
import com.github.Luythen.Login.Service.RegisterService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/register")
    public String regisString(Model model) {
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String regAndView(@ModelAttribute("user") RegisterDto user, HttpServletRequest request, Errors errors) {
        try {
            registerService.registerNewUserAccount(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "register";
        }
        
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}
