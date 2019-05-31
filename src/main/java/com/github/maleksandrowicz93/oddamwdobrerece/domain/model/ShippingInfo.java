package com.github.maleksandrowicz93.oddamwdobrerece.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "shippingInformation")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String postcode;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String time;
    private String moreInfo;

}
