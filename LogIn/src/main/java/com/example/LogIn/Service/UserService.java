package com.example.LogIn.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.LogIn.DTO.LoginRequest;
import com.example.LogIn.DTO.LoginResponse;
import com.example.LogIn.DTO.RegisterRequest;
import com.example.LogIn.Repository.UserRepo;
import com.example.LogIn.User.User;
@Service
public class UserService {

	@Autowired
	private UserRepo employeeRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String registerEmployee(RegisterRequest employeeDTO) {
		User employee = new User(employeeDTO.getEmployeeid(), employeeDTO.getEmployeename(), employeeDTO.getEmail(),
				this.passwordEncoder.encode(employeeDTO.getPassword()));
	
		User employee1 = employeeRepo.findByEmail(employeeDTO.getEmail());
		if (employee1 != null) {
			return "Email already exists";
		}
		employeeRepo.save(employee);
		return employee.getEmployeename();
	}

	public LoginResponse loginEmployee(LoginRequest loginDTO) {
		User employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
		if (employee1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = employee1.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<User> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
				if (employee.isPresent()) {
					return new LoginResponse("Login Success", true);
				} else {
					return new LoginResponse("Login Failed", false);
				}
			} else {
				return new LoginResponse("password Not Match", false);
			}
		} else {
			return new LoginResponse("Email not exits", false);
		}
	}
}
