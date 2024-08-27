package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.NurseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<NurseModel, Long> {
    // Custom query methods can be defined here
}
