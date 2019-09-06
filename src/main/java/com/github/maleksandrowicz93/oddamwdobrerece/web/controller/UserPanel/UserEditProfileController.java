package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.UserPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/app/profile")
public class UserEditProfileController {

    private UserService userService;
    private boolean isUserWasUpdated = false;
    private Long userID;

    public UserEditProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayEditProfileForm(Principal principal, Model model) {
        User user = getUser(principal);
        if (isUserWasUpdated) {
            if (user == null) {
                user = userService.findById(userID);
            }
        }
        UserDTO userDTO = UserConverter.userToUserDto(user);
        model.addAttribute("userDTO", userDTO);
        return "user-editProfile";
    }

    @PostMapping
    public String confirmEditProfileForm(@ModelAttribute UserDTO userDTO, Principal principal, BindingResult result) {
        User user = getUser(principal);
        if (result.hasErrors()) {
            return "redirect:/app/profile";
        }
        if (!userDTO.getPassword().equals("") || !userDTO.getUsername().equals(user.getUsername())) {
            if (!userService.checkPasswordEquality(userDTO)) {
                result.rejectValue("password", null, "Hasło i powtórzone hasło są niezgodne");
                return "redirect:/app/profile";
            }
            if (!userService.checkIsUserNameAvailable(userDTO)) {
                result.rejectValue("username", null, "Nazwa użytkownika jest już zajęta");
                return "redirect:/app/profile";
            }
        }
        userService.saveUserChanges(userDTO, user);
        userService.saveUser(user);
        if (!isUserWasUpdated) {
            userID = user.getId();
        }
        isUserWasUpdated = true;
        return "redirect:/app/profile/success";
    }

    @GetMapping("/success")
    public String displaySuccessEditProfilePage() {
        return "user-editProfile-success";
    }

    private User getUser(Principal principal) {
        return userService.findByUsername(principal.getName());
    }

}
