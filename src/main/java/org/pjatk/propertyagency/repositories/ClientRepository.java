package org.pjatk.propertyagency.repositories;

import org.pjatk.propertyagency.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c")
    List<Client> findAllClientsBasicData();

    @Query("select c from Client c where c.clientId = :id")
    Client findAllClientsData(int id);

}
