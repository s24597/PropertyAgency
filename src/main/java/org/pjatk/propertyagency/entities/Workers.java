package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter@Setter
public abstract class Workers {

    @Transient
    private int baseSalary = 3000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workerId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String surname;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private int seniority;

    @Column(nullable = false, length = 100)
    private String positionName;

    @Column(nullable = false)
    private int grade;

    @ManyToMany
    private List<Report> reports;

    public double getWorkerSalary() {
        return 0;
    }

}
