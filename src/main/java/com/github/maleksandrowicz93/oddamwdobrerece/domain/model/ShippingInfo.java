package com.github.maleksandrowicz93.oddamwdobrerece.domain.model;

import lombok.*;

import javax.persistence.*;

@Embeddable
@Table(name = "shippingInformation")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInfo {

    private String address;
    private String city;
    private String postcode;
    private String phone;
    private String date;
    private String time;
    private String moreInfo;

}
