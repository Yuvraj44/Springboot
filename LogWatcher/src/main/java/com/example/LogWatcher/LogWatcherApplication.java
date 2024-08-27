package com.example.LogWatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class LogWatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogWatcherApplication.class, args);
		System.out.println("Works fine");
	}
}
