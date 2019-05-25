package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/admins/delete")
public class AdminAdminsDeleteController {

    private UserService userService;

    public AdminAdminsDeleteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String displayDeleteAdminPage(@PathVariable("id") Long id, Model model) {
        User admin = userService.findById(id);
        model.addAttribute("admin", admin);
        return "admin-admins-delete";
    }

    @GetMapping("/{id}/confirm")
    public String confirmDeleteAdmin(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/admin/admins";
    }

}
