package com.example.CallerLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CallerLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallerLogApplication.class, args);
		System.out.println("Works fine");
	}

}
