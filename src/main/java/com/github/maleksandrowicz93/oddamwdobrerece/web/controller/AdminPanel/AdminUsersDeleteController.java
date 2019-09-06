package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users/delete")
public class AdminUsersDeleteController {

    private UserService userService;

    public AdminUsersDeleteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String displayDeleteUserPage(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin-users-delete";
    }

    @GetMapping("/{id}/confirm")
    public String confirmDeleteUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/admin/users";
    }

}
