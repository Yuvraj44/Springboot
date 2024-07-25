package com.example.LogIn.Security;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.LogIn.Registration.Token.token;
import com.example.LogIn.Registration.Token.tokenService;
import com.example.LogIn.User.Repo;
import com.example.LogIn.User.User;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Configuration
@RequiredArgsConstructor


public class SignUp {
	
	private final Repo appUserRepository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private final tokenService tokenServiceobj;
	
	 public String signUpUser(User u) {
	        boolean userExists = appUserRepository
	                .findByEmail(u.getEmail())
	                .isPresent();

	        if (userExists) {

	            throw new IllegalStateException("email already taken");
	        }

	        String encodedPassword = bCryptPasswordEncoder.encode(u.getPassword());

	        u.setPassword(encodedPassword);

	        appUserRepository.save(u);
	        
	        String token = UUID.randomUUID().toString();

	        token confirmationToken = new token(
	                token,
	                LocalDateTime.now(),
	                LocalDateTime.now().plusMinutes(15),
	                u
	        );

	        tokenServiceobj.saveConfirmationToken(
	                confirmationToken);
	        return token;
	 }
	 
	 public int enableAppUser(String email) {
	        return appUserRepository.enableUser(email);
	    }


}
