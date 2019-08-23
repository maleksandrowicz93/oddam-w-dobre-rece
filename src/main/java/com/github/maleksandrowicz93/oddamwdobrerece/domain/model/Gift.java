package com.github.maleksandrowicz93.oddamwdobrerece.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gifts")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    @Column(name = "product")
    private List<String> products;
    private Integer amountOfBags;
    private String localization;
    @ElementCollection
    @Column(name = "help")
    private List<String> helpFor;
    private String status;
    private String dateOfCollection;
    @Column(nullable = false)
    private String dateOfGiftRegistration;

    @ManyToOne
    private User user;

    @ManyToOne
    private Organization organization;

    private ShippingInfo shippingInfo;

}
