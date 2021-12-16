package com.cse544.employeemanagementsystem.admin;

import com.cse544.employeemanagementsystem.auth.Role;
import com.cse544.employeemanagementsystem.auth.RoleRepository;
import com.cse544.employeemanagementsystem.auth.User;
import com.cse544.employeemanagementsystem.auth.UserRepository;
import com.cse544.employeemanagementsystem.employee.Employee;
import com.cse544.employeemanagementsystem.employee.EmployeeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(UUID id){
        employeeRepository.deleteById(id);
    }
    public Employee editEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public boolean updateSalaryForAllEmployees(){
        //logic
        return true;
    }
    public boolean updateSalaryForSpecificEmployee(UUID employeeId){
        //logic
        return true;
    }
}
