package com.example.branchchecklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // This will serve your main frontend page
    @GetMapping("/")
    public String home() {
        return "index";  // corresponds to src/main/resources/templates/index.html
    }
}
