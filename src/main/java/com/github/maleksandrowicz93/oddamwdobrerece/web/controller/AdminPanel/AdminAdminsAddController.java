package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/admins/add")
public class AdminAdminsAddController {

    private UserService userService;

    public AdminAdminsAddController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayAddAdminForm(Model model) {
        model.addAttribute("adminDTO", new UserDTO());
        return "admin-admins-add";
    }

    @PostMapping
    public String saveAddAdminForm(@ModelAttribute UserDTO adminDTO) {
        adminDTO.setRole("ADMIN");
        User newAdmin = UserConverter.userDtoToUser(adminDTO);
        userService.saveUser(newAdmin);
        return "redirect:/admin/admins";
    }

}
