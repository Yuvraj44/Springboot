package com.example.LogIn.Registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service

public class EmailValid implements Predicate<String>{

	@Override
	public boolean test(String t) {
		return true;
	}
}
