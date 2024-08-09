package org.pjatk.propertyagency.services;

import org.pjatk.propertyagency.entities.Client;
import org.pjatk.propertyagency.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClientBasic() {return clientRepository.findAllClientsBasicData();}

    public Client getClient(int id) {return clientRepository.findAllClientsData(id);}
}
