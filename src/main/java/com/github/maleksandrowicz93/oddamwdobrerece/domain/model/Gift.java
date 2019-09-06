package com.github.maleksandrowicz93.oddamwdobrerece.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gifts")
@Getter
@Setter
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

    @Override
    public String toString() {
        return "user: " + this.getUser().getUsername() + "\n" +
                "products: " + this.getProducts() + "\n" +
                "bags: " + this.getAmountOfBags() + "\n" +
                "localization: " + this.getLocalization() + "\n" +
                "help: " + this.getHelpFor() + "\n" +
                "organization: " + this.getOrganization().getName() + "\n" +
                "address: " + this.getShippingInfo().getAddress() + "\n" +
                "city: " + this.getShippingInfo().getCity() + "\n" +
                "post code: " + this.getShippingInfo().getPostcode() + "\n" +
                "phone: " + this.getShippingInfo().getPhone() + "\n" +
                "date: " + this.getShippingInfo().getDate() + "\n" +
                "time: " + this.getShippingInfo().getTime() + "\n" +
                "info: " + this.getShippingInfo().getMoreInfo();
    }
}
