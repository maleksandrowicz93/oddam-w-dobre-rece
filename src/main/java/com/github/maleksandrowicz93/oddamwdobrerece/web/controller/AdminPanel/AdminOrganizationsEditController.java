package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.OrganizationDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.UserConverter;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/organizations/edit")
public class AdminOrganizationsEditController {

    private OrganizationService organizationService;

    public AdminOrganizationsEditController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{id}")
    public String displayEditOrganizationForm(@PathVariable("id") Long id, Model model) {
        Organization organization = organizationService.findById(id);
        OrganizationDTO organizationDTO = OrganizationConverter.organizationToOrganizationDTO(organization);
        model.addAttribute("organizationDTO", organizationDTO);
        return "admin-organizations-edit";
    }

    @PostMapping("/{id}")
    public String saveEditOrganizationForm(@PathVariable ("id") Long id, @ModelAttribute OrganizationDTO organizationDTO) {
        Organization organization = organizationService.findById(id);
        OrganizationConverter.saveOrganizationChanges(organizationDTO, organization);
        organizationService.saveOrganization(organization);
        return "redirect:/admin/organizations";
    }

}
