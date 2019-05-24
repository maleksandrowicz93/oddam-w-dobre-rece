package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.OrganizationDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.Converters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/organizations/add")
public class AdminOrganizationsAddController {

    private OrganizationRepository organizationRepository;

    public AdminOrganizationsAddController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping
    public String displayAddOrganizationForm(Model model) {
        model.addAttribute("organizationDTO", new OrganizationDTO());
        return "admin-organizations-add";
    }

    @PostMapping
    public String saveAddOrganizationForm(@ModelAttribute OrganizationDTO organizationDTO) {
        Organization newOrganization = Converters.organizationDtoToOrganization(organizationDTO);
        organizationRepository.save(newOrganization);
        return "redirect:/admin/organizations";
    }

}
