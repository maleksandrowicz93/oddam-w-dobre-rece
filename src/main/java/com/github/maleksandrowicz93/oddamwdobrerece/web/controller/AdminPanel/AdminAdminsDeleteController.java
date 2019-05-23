package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/admins")
public class AdminAdminsDeleteController {

    private UserRepository userRepository;

    public AdminAdminsDeleteController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/delete/{id}")
    public String displayDeleteAdminPage(@PathVariable("id") Long id, Model model) {
        User admin = userRepository.findFirstById(id);
        model.addAttribute("admin", admin);
        return "admin-admins-delete";
    }

    @GetMapping("/delete/{id}/confirm")
    public String confirmDeleteAdmin(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/admins";
    }

}
