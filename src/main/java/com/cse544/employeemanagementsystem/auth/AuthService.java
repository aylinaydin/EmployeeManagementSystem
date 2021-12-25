package com.cse544.employeemanagementsystem.auth;

import com.cse544.employeemanagementsystem.Mapper;
import com.cse544.employeemanagementsystem.employee.Employee;
import com.cse544.employeemanagementsystem.employee.EmployeeDto;
import com.cse544.employeemanagementsystem.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return Mapper.userToUserDto(user);
    }

    @Transactional(readOnly = true)
    public EmployeeDto signUpUser(String email, String password) {
        Employee emp = employeeRepository.findByEmail(email);
        if(emp==null){
            return null;
        }
        emp.setPassword(password);
        Employee employee = employeeRepository.save(emp);

        return Mapper.employeeToEmployeeDto(employee);
    }

    @Transactional(readOnly = true)
    public UserDto login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return Mapper.userToUserDto(user);
        } else {
            return null; // TODO: 400 döndür
        }
    }

}
