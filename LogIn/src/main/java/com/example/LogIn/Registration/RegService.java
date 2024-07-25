package com.example.LogIn.Registration;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.LogIn.Registration.Token.token;
import com.example.LogIn.Registration.Token.tokenService;
import com.example.LogIn.Security.AppConfig;
import com.example.LogIn.Security.SignUp;
import com.example.LogIn.User.Role;
import com.example.LogIn.User.User;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegService {
	private final SignUp confobj;
	private final EmailValid validobj;
	private final tokenService tokenServiceobj;
	
	
	public String register(RegRequest request)
	{
		boolean flag=validobj.test(request.getEmail());
		
		if(!flag)
		{
			throw new IllegalStateException("Ëmail not valid");
		}
		
		return confobj.signUpUser(new User(null, request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(), Role.USER, flag, flag));
	}
	@Transactional
		    public String confirmToken(String token) {
		        token confirmationToken = tokenServiceobj
		                .getToken(token)
		                .orElseThrow(() ->
		                        new IllegalStateException("token not found"));

		        if (confirmationToken.getConfirmedAt() != null) {
		            throw new IllegalStateException("email already confirmed");
		        }

		        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

		        if (expiredAt.isBefore(LocalDateTime.now())) {
		            throw new IllegalStateException("token expired");
		        }

		        tokenServiceobj.setConfirmedAt(token);
		        confobj.enableAppUser(
		                confirmationToken.getAppUser().getEmail());
		        return "confirmed";
		    }
	
}
