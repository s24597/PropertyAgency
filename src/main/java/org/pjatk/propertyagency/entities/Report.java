package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reports")
@Getter@Setter
public class Report {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;


    @Column(nullable = false)
    private double workTime;

    @ManyToOne
    private FullDate fullDate;


}
