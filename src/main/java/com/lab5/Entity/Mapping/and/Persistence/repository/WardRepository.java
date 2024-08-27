package com.lab5.Entity.Mapping.and.Persistence.repository;

import com.lab5.Entity.Mapping.and.Persistence.model.WardModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<WardModel, Long> {
    // Custom query methods can be defined here
}
