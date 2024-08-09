package org.pjatk.propertyagency.services;

import org.pjatk.propertyagency.entities.Process;
import org.pjatk.propertyagency.repositories.ProcessRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProcessService {

    private final ProcessRepository processRepository;

    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    public List<Process> getAllProcessesForClient(int id) { return processRepository.findAllForClient(id);}

    public Process getSpecificProcessData(int id) {return processRepository.findProcessDetails(id);}

    public int extendProcess(LocalDate localDate, int id) {return processRepository.extendRent(localDate,id);}

}
