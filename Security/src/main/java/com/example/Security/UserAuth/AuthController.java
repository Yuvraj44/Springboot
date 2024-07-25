package com.example.Security.UserAuth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService AuthServiceobj;
	
	@PostMapping("/register")
	  public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
	{
	    return ResponseEntity.ok(AuthServiceobj.register(request));
	}
	
	
	 @PostMapping("/authenticate")
	  public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request ) 
	 {
	    return ResponseEntity.ok(AuthServiceobj.authenticate(request));
	  }
}
