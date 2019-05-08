package com.github.maleksandrowicz93.oddamwdobrerece.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class LandingPageController {

    @GetMapping("/")
    public String displayLandingPage() {
        return "landing-page";
    }

}
