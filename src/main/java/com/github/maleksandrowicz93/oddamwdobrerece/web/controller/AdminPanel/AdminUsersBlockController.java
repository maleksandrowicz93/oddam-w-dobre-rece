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
@RequestMapping("/admin/users/block")
public class AdminUsersBlockController {

    private UserService userService;

    public AdminUsersBlockController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String displayBlockUserPage(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin-users-block";
    }

    @GetMapping("/{id}/confirm")
    public String confirmBlockUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        user.setIsBlocked(true);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

}
