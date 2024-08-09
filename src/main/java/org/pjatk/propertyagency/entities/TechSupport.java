package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tech_supports")
@Getter@Setter
public class TechSupport extends Workers{

    private enum specialities {
        Admin,Cybersec,Office
    }

    @Column
    private int bonus;

    @Enumerated(EnumType.STRING)
    private specialities speciality;

    @Override
    public double getWorkerSalary() {
        return super.getBaseSalary() + bonus;
    }

}
