package org.pjatk.propertyagency.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "decisions")
public class Decision {

    public enum decisionType {
        CONSIDERED_POSITIVE,CONSIDERED_NEGATIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int decisionId;

    @Enumerated(EnumType.STRING)
    private decisionType decisionType;

    @Column
    private String description;

    @Column(nullable = false)
    private LocalDate decisionDate;

}
