package org.pjatk.propertyagency.services;

import org.pjatk.propertyagency.entities.Consultant;
import org.pjatk.propertyagency.repositories.ConsultantRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;

    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public Integer getCaseCompleted(int id) {return consultantRepository.caseCompleted(id);}

    public Double getSalaryBonus(int id) {return consultantRepository.salaryBonus(id);}

    public Consultant findByWorkerId(int id) {return consultantRepository.findByWorkerId(id);}
}
