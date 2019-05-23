package com.github.maleksandrowicz93.oddamwdobrerece.services;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.User;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.OrganizationDTO;
import com.github.maleksandrowicz93.oddamwdobrerece.dtos.UserDTO;

public class Converters {

    public static User userDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setIsAdmin(userDTO.getIsAdmin());
        return user;
    }

    public static UserDTO userToUserDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static Organization organizationDtoToOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        organization.setName(organizationDTO.getName());
        organization.setType(organizationDTO.getType());
        organization.setLocalization(organizationDTO.getLocalization());
        organization.setAddress(organizationDTO.getAddress());
        organization.setDescription(organizationDTO.getDescription());
        organization.setForWhom(organizationDTO.getForWhom());
        return organization;
    }

    public static OrganizationDTO organizationToOrganiztaionDTO(Organization organization) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setName(organization.getName());
        organizationDTO.setType(organization.getType());
        organizationDTO.setLocalization(organization.getLocalization());
        organizationDTO.setAddress(organization.getAddress());
        organizationDTO.setDescription(organization.getDescription());
        organizationDTO.setForWhom(organization.getForWhom());
        return organizationDTO;
    }
}
