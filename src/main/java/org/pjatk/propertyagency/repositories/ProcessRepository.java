package org.pjatk.propertyagency.repositories;

import jakarta.transaction.Transactional;
import org.pjatk.propertyagency.entities.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {

    @Query("select p from Process p where p.client.clientId = :id")
    List<Process> findAllForClient(int id);

    @Query("select p from Process p where p.processId = :id")
    Process findProcessDetails(int id);

    @Modifying
    @Transactional
    @Query("update Process p set p.rentEndDate = :endDate, p.rentStartDate = local date where p.processId = :id")
    int extendRent(LocalDate endDate, int id);

}
