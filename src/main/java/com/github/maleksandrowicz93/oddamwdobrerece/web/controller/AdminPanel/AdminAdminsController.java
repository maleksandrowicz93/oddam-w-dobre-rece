package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/admins")
public class AdminAdminsController {

    private UserRepository userRepository;

    public AdminAdminsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String displayAdminsCrudPage() {
        return "admin-admins";
    }

    @ModelAttribute("admins")
    public List<User> getAllAdmins() {
        return userRepository.findAllByIsAdmin(true);
    }

}
