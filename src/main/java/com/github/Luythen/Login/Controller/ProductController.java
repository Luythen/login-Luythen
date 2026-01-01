package com.github.Luythen.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ProductController {

    @GetMapping("/")
    public String indexProduct() {
        return "index";
    }

    @GetMapping("/product/{id}")
    public String getMethodName(@RequestParam String param) {
        return "product";
    }

}
