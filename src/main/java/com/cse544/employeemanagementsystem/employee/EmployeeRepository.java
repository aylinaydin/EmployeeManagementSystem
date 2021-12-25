package com.cse544.employeemanagementsystem.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Employee findByEmail(String email);
    List<Employee> findAll();
    List<Employee> findByManagerId(UUID id);
}
