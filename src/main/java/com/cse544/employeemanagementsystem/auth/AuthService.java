package com.cse544.employeemanagementsystem.auth;

import com.cse544.employeemanagementsystem.employee.Employee;
import com.cse544.employeemanagementsystem.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Employee signUpUser(Employee employee) {
        return userRepository.save(employee);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
