package org.pjatk.propertyagency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "full_dates")
@Getter@Setter
public class FullDate {

    public enum months {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fulldateId;

    @Column(nullable = false)
    private int year;

    @Enumerated(EnumType.STRING)
    private months month;


}
