package com.example.Security.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Security.UserRepo.repo;

import lombok.Data;

@RestController
@RequestMapping("/disp")
@Data
public class UserController {
	private final repo repoobj;
  @GetMapping
  public ResponseEntity<List<User>> sayHello() {
    return ResponseEntity.ok(repoobj.findAll());
  }

}

