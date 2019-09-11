package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.OrganizationDTO;

public class OrganizationConverter {

    public static Organization organizationDtoToOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        organization.setName(organizationDTO.getName());
        organization.setType(organizationDTO.getType());
        organization.setLocalization(organizationDTO.getLocalization());
        organization.setAddress(organizationDTO.getAddress());
        organization.setDescription(organizationDTO.getDescription());
        organization.setForWhom(organizationDTO.getForWhom());
        organization.setNeeds(organizationDTO.getNeeds());
        return organization;
    }

    public static OrganizationDTO organizationToOrganizationDTO(Organization organization) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setName(organization.getName());
        organizationDTO.setType(organization.getType());
        organizationDTO.setLocalization(organization.getLocalization());
        organizationDTO.setAddress(organization.getAddress());
        organizationDTO.setDescription(organization.getDescription());
        organizationDTO.setForWhom(organization.getForWhom());
        organizationDTO.setNeeds(organization.getNeeds());
        return organizationDTO;
    }

    public static void saveOrganizationChanges(OrganizationDTO organizationDTO, Organization organization) {
        organization.setName(organizationDTO.getName());
        organization.setType(organizationDTO.getType());
        organization.setLocalization(organizationDTO.getLocalization());
        organization.setAddress(organizationDTO.getAddress());
        organization.setDescription(organizationDTO.getDescription());
        organization.setForWhom(organizationDTO.getForWhom());
        organization.setNeeds(organizationDTO.getNeeds());
    }

}
