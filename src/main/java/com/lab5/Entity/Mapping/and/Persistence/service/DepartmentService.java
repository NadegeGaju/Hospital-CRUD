package com.lab5.Entity.Mapping.and.Persistence.service;

import com.lab5.Entity.Mapping.and.Persistence.model.DepartmentModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentModel saveDepartment(DepartmentModel department) {
        return departmentRepository.save(department);
    }

    public List<DepartmentModel> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<DepartmentModel> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
