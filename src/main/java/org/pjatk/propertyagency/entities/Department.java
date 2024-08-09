package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter@Setter
public class Department {

    public enum type {
        SALES,RENT,BOK
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Enumerated(EnumType.STRING)
    private type type;

    @OneToMany
    private List<Workers> workers;

    @OneToOne
    private Address address;

}
