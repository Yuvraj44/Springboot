package com.example.LogIn.Registration;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor

public class RegController {
	private final RegService regserobj;
	
	@PostMapping("/register")
	public String register(@RequestBody RegRequest request)
	{
		return regserobj.register(request);
	}
	
	@GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return regserobj.confirmToken(token);
    }
}

