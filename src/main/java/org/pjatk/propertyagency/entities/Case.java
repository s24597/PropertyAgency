package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "cases")
@Getter@Setter
public class Case{

    public enum stages {
        NEW,OPEN,UNDER_CONSIDERATION,ACCEPTED,DENIED,RESOLVED,UNRESOLVED,ARCHIVED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caseId;

    @Enumerated(EnumType.STRING)
    private stages stage;

    @Column(nullable = false, unique = true)
    private String symbol;

    @Column(nullable = false)
    private LocalDate createDate;

    @Column
    private String description;

    @Column
    private LocalDate closeDate;

    @ManyToMany
    private List<Apartment> apartments;

    @OneToMany
    private List<Decision> decisions;

}
