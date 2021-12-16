package com.cse544.employeemanagementsystem.auth;

import com.cse544.employeemanagementsystem.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/user")
    public User getUserByEmail(@RequestParam String email) {
        return authService.getUserByEmail(email);
    }

    @PutMapping("/signup")
    public Employee signUp(@RequestBody Employee employee) {
        return authService.signUpUser(employee);
    }

    @GetMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return authService.login(email, password);
    }
}
