package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserEditProfileController {

    @GetMapping
    public String displayEditProfileForm() {
        return "user-editProfile";
    }

}
