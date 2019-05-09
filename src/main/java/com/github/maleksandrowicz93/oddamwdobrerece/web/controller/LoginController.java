package com.github.maleksandrowicz93.oddamwdobrerece.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/login")
public class LoginController {

    @GetMapping
    public String displayLoginPage() {
        return "login-page";
    }

}
