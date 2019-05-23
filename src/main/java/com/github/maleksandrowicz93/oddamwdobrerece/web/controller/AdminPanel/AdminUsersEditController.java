package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.Converters;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users/edit")
public class AdminUsersEditController {

    private UserRepository userRepository;
    private UserService userService;

    public AdminUsersEditController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String displayEditUserForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findFirstById(id);
        UserDTO userDTO = Converters.userToUserDto(user);
        model.addAttribute("userDTO", userDTO);
        return "admin-users-edit";
    }

    @PostMapping("/{id}")
    public String saveEditUserForm(@PathVariable ("id") Long id, @ModelAttribute UserDTO userDTO) {
        User user = userRepository.findFirstById(id);
        userService.updateUser(userDTO, user);
        return "redirect:/admin/users";
    }

}
