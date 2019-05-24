package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.OrganizationDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationService {

    @Transactional
    public void updateOrganization(OrganizationDTO organizationDTO, Organization organization) {
        organization.setName(organizationDTO.getName());
        organization.setType(organizationDTO.getType());
        organization.setLocalization(organizationDTO.getLocalization());
        organization.setAddress(organizationDTO.getAddress());
        organization.setDescription(organizationDTO.getDescription());
        organization.setForWhom(organizationDTO.getForWhom());
    }

}
