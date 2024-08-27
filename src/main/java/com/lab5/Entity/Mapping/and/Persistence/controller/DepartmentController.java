package com.lab5.Entity.Mapping.and.Persistence.controller;

import com.lab5.Entity.Mapping.and.Persistence.model.DepartmentModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public DepartmentModel createDepartment(@RequestBody DepartmentModel department) {
        return departmentRepository.save(department);
    }

    @GetMapping
    public List<DepartmentModel> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DepartmentModel> getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id);
    }

    @PutMapping("/{id}")
    public DepartmentModel updateDepartment(@PathVariable Long id, @RequestBody DepartmentModel department) {
        department.setCode(id);
        return departmentRepository.save(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }
}
