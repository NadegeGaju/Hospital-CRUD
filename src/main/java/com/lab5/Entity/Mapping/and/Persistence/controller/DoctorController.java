package com.lab5.Entity.Mapping.and.Persistence.controller;

import com.lab5.Entity.Mapping.and.Persistence.model.DoctorModel;
import com.lab5.Entity.Mapping.and.Persistence.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public DoctorModel createDoctor(@RequestBody DoctorModel doctor) {
        return doctorRepository.save(doctor);
    }

    @GetMapping
    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DoctorModel> getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id);
    }

    @PutMapping("/{id}")
    public DoctorModel updateDoctor(@PathVariable Long id, @RequestBody DoctorModel doctor) {
        doctor.setEmployeeNumber(id);
        return doctorRepository.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }
}
