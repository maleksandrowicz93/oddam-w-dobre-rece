package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/organizations")
public class AdminOrganizationsController {

    private OrganizationService organizationService;

    public AdminOrganizationsController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public String displayOrganizationsCrudPage() {
        return "admin-organizations";
    }

    @ModelAttribute("organizations")
    public List<Organization> getAllOrganizations() {
        return organizationService.findAllOrganizations();
    }

}
