package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users/edit")
public class AdminUsersEditController {

    private UserService userService;

    public AdminUsersEditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String displayEditUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        UserDTO userDTO = UserConverter.userToUserDto(user);
        model.addAttribute("userDTO", userDTO);
        return "admin-users-edit";
    }

    @PostMapping("/{id}")
    public String saveEditUserForm(@PathVariable ("id") Long id, @ModelAttribute UserDTO userDTO) {
        User user = userService.findById(id);
        userService.saveUserChanges(userDTO, user);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

}
