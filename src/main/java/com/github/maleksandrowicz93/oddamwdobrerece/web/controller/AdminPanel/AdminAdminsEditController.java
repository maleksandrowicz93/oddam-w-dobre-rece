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
@RequestMapping("/admin/admins/edit")
public class AdminAdminsEditController {

    private UserService userService;

    public AdminAdminsEditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String displayEditAdminForm(@PathVariable("id") Long id, Model model) {
        User admin = userService.findById(id);
        UserDTO adminDTO = UserConverter.userToUserDto(admin);
        model.addAttribute("adminDTO", adminDTO);
        return "admin-admins-edit";
    }

    @PostMapping("/{id}")
    public String saveEditAdminForm(@PathVariable ("id") Long id, @ModelAttribute UserDTO adminDTO) {
        User admin = userService.findById(id);
        userService
                .saveUserChanges(adminDTO, admin);
        userService.saveUser(admin);
        return "redirect:/admin/admins";
    }

}
