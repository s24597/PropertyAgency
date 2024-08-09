package org.pjatk.propertyagency.repositories;

import org.pjatk.propertyagency.entities.Client;
import org.pjatk.propertyagency.entities.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    @Query("select caseCompleted from Consultant where workerId = :id")
    Integer caseCompleted(int id);

    @Query("select salaryBonus from Consultant where workerId = :id")
    Double salaryBonus(int id);

    @Query("select c from Consultant c where c.workerId = :id")
    Consultant findByWorkerId(int id);

}
