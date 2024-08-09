package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "processes")
@Getter@Setter
public class Process {

    public enum stages {
        OPEN,AGREEMENT_SIGNED,ENDED
    }

    public enum types {
        SALE,RENT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int processId;

    @Column
    private LocalDate agreementSignDate;

    @Column
    private LocalDate rentStartDate;

    @Column
    private LocalDate rentEndDate;

    @Enumerated(EnumType.STRING)
    private stages stage;

    @Enumerated(EnumType.STRING)
    private types type;

    @ManyToOne
    private Consultant consultants;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Apartment property;

}
