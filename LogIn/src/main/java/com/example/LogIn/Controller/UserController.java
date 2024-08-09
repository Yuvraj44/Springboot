package com.example.LogIn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LogIn.DTO.LoginRequest;
import com.example.LogIn.DTO.LoginResponse;
import com.example.LogIn.DTO.RegisterRequest;
import com.example.LogIn.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("auth/")
public class UserController {
	@Autowired
    private UserService employeeService;
	
    public UserController(UserService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping(path = "/register")
    public String saveEmployee(@RequestBody RegisterRequest employeeDTO)
    {
        String name = employeeService.registerEmployee(employeeDTO);
        return name;
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponse> loginEmployee(@RequestBody LoginRequest loginDTO)
    {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}


