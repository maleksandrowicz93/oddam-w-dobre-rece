package com.github.maleksandrowicz93.oddamwdobrerece.domain.model;

import lombok.*;

import javax.persistence.*;

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
    @Column(unique = true, nullable = false)
    private String name;
    private String state;
    private String dateOfCollection;
    @Column(nullable = false)
    private String dateOfGiftRegistration;
    private String type;
    private Integer amountOfBags;

    @ManyToOne
    private User user;

    @ManyToOne
    private Organization organization;

}
