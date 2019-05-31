package com.github.maleksandrowicz93.oddamwdobrerece.dtos;

import com.github.maleksandrowicz93.oddamwdobrerece.domain.model.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftDTO {

    private String name;
    private List<String> products;
    private Integer amountOfBags;
    private String localization;
    private List<String> helpFor;
    private String organizationName;
    private Organization organization;

    private String address;
    private String city;
    private String postcode;
    private String phone;
    private String date;
    private String time;
    private String moreInfo;

}
