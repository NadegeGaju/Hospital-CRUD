package com.lab5.Entity.Mapping.and.Persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nurse")
public class NurseModel extends EmployeeModel {
    private String rotation;
    private double salary;
    // Getters and setters
}
