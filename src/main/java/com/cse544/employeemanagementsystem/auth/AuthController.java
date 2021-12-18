package com.cse544.employeemanagementsystem.auth;

import com.cse544.employeemanagementsystem.employee.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/user")
    public UserDto getUserByEmail(@RequestParam String email) {
        return authService.getUserByEmail(email);
    }

    @PutMapping("/signup")
    public EmployeeDto signUp(@RequestParam String email,@RequestParam String password) {
        return authService.signUpUser(email, password);
    }

    @GetMapping("/login")
    public UserDto login(@RequestParam String email, @RequestParam String password) {
        UserDto userDto = authService.login(email, password);
        return userDto;
    }
}
