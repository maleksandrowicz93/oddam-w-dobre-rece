package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/organizations/delete")
public class AdminOrganizationsDeleteController {

    private OrganizationRepository organizationRepository;

    public AdminOrganizationsDeleteController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/{id}")
    public String displayDeleteOrganizationPage(@PathVariable("id") Long id, Model model) {
        Organization organization = organizationRepository.findFirstById(id);
        model.addAttribute("organization", organization);
        return "admin-organizations-delete";
    }

    @GetMapping("/{id}/confirm")
    public String confirmDeleteOrganization(@PathVariable("id") Long id) {
        organizationRepository.deleteById(id);
        return "redirect:/admin/organizations";
    }

}
