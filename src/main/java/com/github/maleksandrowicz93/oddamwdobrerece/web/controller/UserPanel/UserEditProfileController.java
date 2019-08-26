package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserEditProfileController {

    private UserService userService;

    public UserEditProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayEditProfileForm(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        UserDTO userDTO = UserConverter.userToUserDto(user);
        model.addAttribute("userDTO", userDTO);
        return "user-editProfile";
    }

}
