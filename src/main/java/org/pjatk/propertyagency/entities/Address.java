package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 100)
    private int streetNumber;

    @Column
    private Integer houseNumber;

    @Column(nullable = false, length = 100)
    private String zipcode;

    @Column(nullable = false, length = 100)
    private String city;

}
