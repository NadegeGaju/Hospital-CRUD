package com.lab5.Entity.Mapping.and.Persistence.repository;

import java.util.List;
import com.lab5.Entity.Mapping.and.Persistence.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    List<DepartmentModel> findByName(String name);
}

