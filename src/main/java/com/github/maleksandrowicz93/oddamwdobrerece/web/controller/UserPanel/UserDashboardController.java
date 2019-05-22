package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class UserDashboardController {

    @GetMapping
    public String displayAdminDashboard() {
        return "user-dashboard";
    }

}
