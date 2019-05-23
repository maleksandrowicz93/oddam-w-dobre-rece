package com.github.maleksandrowicz93.oddamwdobrerece.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {

    private String name;
    private String type;
    private String localization;
    private String address;
    private String description;
    private String forWhom;

}
