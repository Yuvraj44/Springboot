package com.example.FileWatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileWatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileWatcherApplication.class, args);
		System.out.println("Works fine");
	}

}
