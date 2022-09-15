package com.javaweb.myCodeJava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "index";

    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signupForm";
    }
}
