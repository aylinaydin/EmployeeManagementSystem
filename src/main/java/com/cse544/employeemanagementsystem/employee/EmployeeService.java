package com.cse544.employeemanagementsystem.employee;

import com.cse544.employeemanagementsystem.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public EmployeeDto getEmployeeInfo(UUID employeeID){
        Employee emp =  employeeRepository.findById(employeeID).orElse(null);
        return Mapper.employeeToEmployeeDto(emp);
    }

    public Boolean enterLeaves(int requestedLeaveNum, UUID id){
        Employee emp = employeeRepository.findById(id).orElse(null);
        int leaves = emp.getAnnualLeave();
        if(leaves>requestedLeaveNum){
            leaves = leaves - requestedLeaveNum;
            emp.setAnnualLeave(leaves);
            employeeRepository.save(emp);
            return true;
        }
        return false;
    }

}
