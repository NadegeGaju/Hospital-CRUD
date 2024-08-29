package com.lab5.Entity.Mapping.and.Persistence.service;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import com.lab5.Entity.Mapping.and.Persistence.model.DepartmentModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DepartmentRepository;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public DepartmentModel createDepartment(DepartmentModel department) {
        return departmentRepository.save(department);
    }

    @Transactional(readOnly = true)
    @Cacheable("departments")
    public List<DepartmentModel> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    public DepartmentModel updateDepartment(Long id, DepartmentModel department) {
        department.setCode(id);
        return departmentRepository.save(department);
    }

    @CacheEvict(value = "departments", allEntries = true)
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Cacheable("departments")
    public DepartmentModel getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
