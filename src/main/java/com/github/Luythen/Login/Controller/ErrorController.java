package com.github.Luythen.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ErrorController {

    @GetMapping("/error")
    public String errorPage(@RequestParam String param) {
        return "error";
    }
    

}
