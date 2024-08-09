package org.pjatk.propertyagency.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consultants")
@Getter@Setter
public class Consultant extends Workers {

    @Column
    private int caseCompleted;

    @Column
    private double salaryBonus;

    @Override
    public double getWorkerSalary() {
        return super.getBaseSalary() * salaryBonus;
    }

}
