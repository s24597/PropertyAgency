package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "apartments")
@Getter@Setter
public class Apartment {

    public enum finishStates {
        RAW,DEVELOPER,TURNKEY
    }

    public enum type {
        HOUSE,FLAT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int apartmentId;

    @Column(nullable = false)
    private double area;

    @Column(nullable = false)
    private int rooms;

    @Column(nullable = false)
    private double grossPrice;

    @Column(nullable = false)
    private boolean isRented;

    @Column
    private Integer floorNumber;

    @Column
    private Integer parkingSpaceNumber;

    @Column
    private Double areaOfGarden;

    @Column
    private Boolean isContainGarage;

    @Enumerated(EnumType.STRING)
    private type type;

    @Enumerated(EnumType.STRING)
    private finishStates finishState;

    @OneToOne(optional = false)
    private Address address;

}
