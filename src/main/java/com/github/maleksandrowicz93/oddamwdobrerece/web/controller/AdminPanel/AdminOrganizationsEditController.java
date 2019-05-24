package com.github.maleksandrowicz93.oddamwdobrerece.web.controller.AdminPanel;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.repositories.OrganizationRepository;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.OrganizationDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.services.Converters;
import com.github.maleksandrowicz93.oddamwdobrerece.services.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/organizations/edit")
public class AdminOrganizationsEditController {

    private OrganizationRepository organizationRepository;
    private OrganizationService organizationService;

    public AdminOrganizationsEditController(OrganizationRepository organizationRepository, OrganizationService organizationService) {
        this.organizationRepository = organizationRepository;
        this.organizationService = organizationService;
    }

    @GetMapping("/{id}")
    public String displayEditOrganizationForm(@PathVariable("id") Long id, Model model) {
        Organization organization = organizationRepository.findFirstById(id);
        OrganizationDTO organizationDTO = Converters.organizationToOrganiztaionDTO(organization);
        model.addAttribute("organizationDTO", organizationDTO);
        return "admin-organizations-edit";
    }

    @PostMapping("/{id}")
    public String saveEditOrganizationForm(@PathVariable ("id") Long id, @ModelAttribute OrganizationDTO organizationDTO) {
        Organization organization = organizationRepository.findFirstById(id);
        organizationService.updateOrganization(organizationDTO, organization);
        return "redirect:/admin/organizations";
    }

}
