package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller("/app/profile")
public class UserEditProfileController {

    private UserService userService;

    public UserEditProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayEditProfileForm(Principal principal, Model model) {
        User user = getUser(principal);
        UserDTO userDTO = UserConverter.userToUserDto(user);
        model.addAttribute("userDTO", userDTO);
        return "user-editProfile";
    }

    @PostMapping
    public String confirmEditProfileForm(@ModelAttribute UserDTO userDTO, Principal principal) {
        User user = getUser(principal);
        UserConverter.saveUserChanges(userDTO, user);
        userService.saveUser(user);
        return "redirect:/app/profile/success";
    }

    private User getUser(Principal principal) {
        return userService.findByUsername(principal.getName());
    }

}
