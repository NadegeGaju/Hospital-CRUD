package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.HospitalizationModel;
import com.lab5.Entity.Mapping.and.Persistence.model.WardModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.HospitalizationRepository;
import com.lab5.Entity.Mapping.and.Persistence.repository.WardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalizationService {

    private final HospitalizationRepository hospitalizationRepository;
    private final WardRepository wardRepository;

    public HospitalizationService(HospitalizationRepository hospitalizationRepository, WardRepository wardRepository) {
        this.hospitalizationRepository = hospitalizationRepository;
        this.wardRepository = wardRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void handleHospitalization(HospitalizationModel hospitalization) {
        // Step 1: Assign a bed in the ward
        WardModel ward = hospitalization.getWard();
        int availableBeds = ward.getBeds();

        if (availableBeds <= 0) {
            throw new RuntimeException("No available beds in the selected ward.");
        }

        // Step 2: Update the ward with the new bed assignment
        ward.setBeds(availableBeds - 1);
        wardRepository.save(ward);

        // Step 3: Save the hospitalization record
        hospitalizationRepository.save(hospitalization);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void transferPatient(HospitalizationModel currentHospitalization, WardModel newWard) {
        // Step 1: Discharge from the current ward
        WardModel currentWard = currentHospitalization.getWard();
        currentWard.setBeds(currentWard.getBeds() + 1); // Free up a bed in the current ward
        wardRepository.save(currentWard);

        // Step 2: Update hospitalization with new ward info
        currentHospitalization.setWard(newWard);

        // Step 3: Assign a bed in the new ward
        int availableBeds = newWard.getBeds();
        if (availableBeds <= 0) {
            throw new RuntimeException("No available beds in the new ward.");
        }

        newWard.setBeds(availableBeds - 1);
        wardRepository.save(newWard);

        // Step 4: Update hospitalization record
        hospitalizationRepository.save(currentHospitalization);
    }
}
