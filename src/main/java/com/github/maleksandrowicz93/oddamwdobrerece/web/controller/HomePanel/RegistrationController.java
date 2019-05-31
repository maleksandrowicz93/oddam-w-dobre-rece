package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.HomePanel;

import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayRegistrationPage(Model model) {
        model.addAttribute("newUser", new UserDTO());
        return "registration-page";
    }

    @PostMapping
    public String registrationProcess(@Valid @ModelAttribute("newUser") UserDTO newUser, BindingResult result) {
        if (result.hasErrors()) {
            return "registration-page";
        }
        if (!checkPasswordEquality(newUser)) {
            result.rejectValue("password", null, "Hasło i powtórzone hasło są niezgodne");
            return "registration-page";
        }
        if (!checkIsUserNameAvailable(newUser)) {
            result.rejectValue("username", null, "Nazwa użytkownika jest już zajęta");
            return "registration-page";
        }
        userService.registerUser(newUser);
        return "redirect:/";
    }

    private boolean checkPasswordEquality(UserDTO newUser) {
        return newUser.getPassword().equals(newUser.getConfirmedPassword());
    }

    private boolean checkIsUserNameAvailable(UserDTO newUser) {
        UserDTO user = userService.findUser(newUser.getUsername());
        return user == null;
    }

}
