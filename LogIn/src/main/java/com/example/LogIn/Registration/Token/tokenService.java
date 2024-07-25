package com.example.LogIn.Registration.Token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class tokenService {
	private final TokenRepo TokenRepoobj;

    public void saveConfirmationToken(token token) {
    	TokenRepoobj.save(token);
    }

    public Optional<token> getToken(String token) {
        return TokenRepoobj.findByToken(token);
    }
    public int setConfirmedAt(String token) {
        return TokenRepoobj.updateConfirmedAt(
                token, LocalDateTime.now());
    }
    
}
