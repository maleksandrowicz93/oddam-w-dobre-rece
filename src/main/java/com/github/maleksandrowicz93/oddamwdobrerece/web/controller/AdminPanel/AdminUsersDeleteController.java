package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users/delete")
public class AdminUsersDeleteController {

    private UserRepository userRepository;

    public AdminUsersDeleteController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public String displayDeleteUserPage(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findFirstById(id);
        model.addAttribute("user", user);
        return "admin-users-delete";
    }

    @GetMapping("/{id}/confirm")
    public String confirmDeleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }

}
