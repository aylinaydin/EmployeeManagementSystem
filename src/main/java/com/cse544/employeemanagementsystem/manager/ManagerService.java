package com.cse544.employeemanagementsystem.manager;

import com.cse544.employeemanagementsystem.Mapper;
import com.cse544.employeemanagementsystem.employee.Employee;
import com.cse544.employeemanagementsystem.employee.EmployeeDto;
import com.cse544.employeemanagementsystem.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ManagerService {
    EmployeeRepository employeeRepository;

    public void setGradeForEmployee(UUID employeeId, int grade){
        Employee emp = employeeRepository.findById(employeeId).orElse(null);
        emp.setGrade(grade);
    }
    public List<EmployeeDto> getAllSubordinateEmployees(UUID id){
        List<Employee> employee = employeeRepository.findByManagerId(id);
        List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
        for (Employee value : employee) {
            EmployeeDto emp = Mapper.employeeToEmployeeDto(value);
            employeeDtoList.add(emp);
        }
        //logic
        return employeeDtoList;
    }
}
