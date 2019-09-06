package com.github.maleksandrowicz93.oddamwdobrerece.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String localization;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String forWhom;

    @OneToMany
    private List<Gift> receivedGifts;

}
