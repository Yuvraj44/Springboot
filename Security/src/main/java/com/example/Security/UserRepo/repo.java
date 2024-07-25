package com.example.Security.UserRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Security.user.User;

public interface repo extends JpaRepository<User,Integer>{
	Optional <User> findByEmail(String email);
}
