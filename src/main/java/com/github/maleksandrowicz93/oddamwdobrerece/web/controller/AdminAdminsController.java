package com.github.maleksandrowicz93.oddamwdobrerece.web.controller;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.Converters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/add")
    public String displayAddAdminForm(Model model) {
        model.addAttribute("adminDTO", new UserDTO());
        return "admin-admins-add";
    }

    @PostMapping("/add")
    public String saveAddAdminForm(@ModelAttribute UserDTO adminDTO) {
        adminDTO.setIsAdmin(true);
        User newAdmin = Converters.userDtoToUser(adminDTO);
        userRepository.save(newAdmin);
        return "redirect:/admin/admins";
    }

    @ModelAttribute("admins")
    public List<User> getAllAdmins() {
        return userRepository.findAllByIsAdmin(true);
    }

}
