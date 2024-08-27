package com.example.CallerLog.DTO;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CallerLog.SecurityConfiguration.jwtService;
import com.example.CallerLog.User.UserRepo;
import com.example.CallerLog.User.callUser;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager; 
    private final UserRepo repoobj;
    private final PasswordEncoder passwordEncoder;
    private final jwtService jwtServiceobj;

    @PostMapping("/login")
    public ResponseEntity<AuthRespone> authenticateUser(@RequestBody AuthRequest request) {
    	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword()));
		var user=repoobj.findByPhoneNumber(request.getPhoneNumber()).orElseThrow();
		var jwtToken = jwtServiceobj.generateToken(user);
		return ResponseEntity.ok(AuthRespone.builder().token(jwtToken).build());
    }

    @PostMapping("/register")
    public ResponseEntity<AuthRespone> registerUser(@RequestBody RegisterRequest request) {
        var user = callUser.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        repoobj.save(user);
        var jwtToken = jwtServiceobj.generateToken(user);
        return ResponseEntity.ok(AuthRespone.builder().token(jwtToken).build());
    }
}
