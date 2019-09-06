package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/organizations/delete")
public class AdminOrganizationsDeleteController {

    private OrganizationService organizationService;

    public AdminOrganizationsDeleteController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{id}")
    public String displayDeleteOrganizationPage(@PathVariable("id") Long id, Model model) {
        Organization organization = organizationService.findById(id);
        model.addAttribute("organization", organization);
        return "admin-organizations-delete";
    }

    @GetMapping("/{id}/confirm")
    public String confirmDeleteOrganization(@PathVariable("id") Long id) {
        Organization organization = organizationService.findById(id);
        organizationService.deleteOrganization(organization);
        return "redirect:/admin/organizations";
    }

}
