package com.lab5.Entity.Mapping.and.Persistence.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.lab5.Entity.Mapping.and.Persistence.model.DoctorModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DoctorRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final PlatformTransactionManager transactionManager;

    public DoctorService(DoctorRepository doctorRepository, PlatformTransactionManager transactionManager) {
        this.doctorRepository = doctorRepository;
        this.transactionManager = transactionManager;
    }

    public DoctorModel createDoctor(DoctorModel doctor) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            DoctorModel savedDoctor = doctorRepository.save(doctor);
            transactionManager.commit(status);
            return savedDoctor;
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}
