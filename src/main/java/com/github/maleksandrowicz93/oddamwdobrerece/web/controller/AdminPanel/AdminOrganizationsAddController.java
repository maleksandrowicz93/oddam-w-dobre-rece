package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.OrganizationDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationService;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/organizations/add")
public class AdminOrganizationsAddController {

    private OrganizationService organizationService;

    public AdminOrganizationsAddController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public String displayAddOrganizationForm(Model model) {
        model.addAttribute("organizationDTO", new OrganizationDTO());
        return "admin-organizations-add";
    }

    @PostMapping
    public String saveAddOrganizationForm(@ModelAttribute OrganizationDTO organizationDTO) {
        Organization newOrganization = OrganizationConverter.organizationDtoToOrganization(organizationDTO);
        organizationService.saveOrganization(newOrganization);
        return "redirect:/admin/organizations";
    }

}
