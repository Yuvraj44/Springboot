package com.example.Security.UserAuth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Security.UserRepo.repo;
import com.example.Security.UserSecurity.jwtService;
import com.example.Security.user.Role;
import com.example.Security.user.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final repo repoobj;
	private final jwtService jwtServiceobj;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public AuthResponse register(RegisterRequest request) {
		var user = User.builder().firstname(request.getFirstname()).lastname(request.getLastname())
				.email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER).build();

		repoobj.save(user);
		var jwtToken = jwtServiceobj.generateToken(user);
		return AuthResponse.builder().token(jwtToken).build();
	}

	public AuthResponse authenticate(AuthRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user=repoobj.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtServiceobj.generateToken(user);
		return AuthResponse.builder().token(jwtToken).build();
	}
}
