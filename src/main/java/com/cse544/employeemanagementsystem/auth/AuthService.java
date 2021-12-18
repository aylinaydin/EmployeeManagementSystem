package com.cse544.employeemanagementsystem.auth;

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
        return userToUserDto(user);
    }

    @Transactional(readOnly = true)
    public EmployeeDto signUpUser(String email, String password) {
        Employee emp = employeeRepository.findByEmail(email);
        if(emp==null){
            return null;
        }
        emp.setPassword(password);
        Employee employee = employeeRepository.save(emp);

        return employeeToEmployeeDto(employee);
    }

    @Transactional(readOnly = true)
    public UserDto login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return userToUserDto(user);
        } else {
            return null; // TODO: 400 döndür
        }
    }

    private UserDto userToUserDto(User user) {
        RoleInfo roleInfo = new RoleInfo(user.getRole().getRoleId(), user.getRole().getName());
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                roleInfo
        );
    }

    private EmployeeDto employeeToEmployeeDto(Employee employee) {
        UserDto userDto = userToUserDto(employee);

        return new EmployeeDto(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.isEnabled(),
                userDto.getRole(),
                employee.getTitle(),
                employee.getSalary(),
                employee.getAnnualLeave(),
                employee.getGrade(),
                employee.getManagerId()
        );
    }
}
