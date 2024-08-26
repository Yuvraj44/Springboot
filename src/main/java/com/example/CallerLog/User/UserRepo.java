package com.example.CallerLog.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<callUser, Long> {
	Optional<callUser> findByPhoneNumber(String phoneNumber);
    List<callUser> findByNameContainingIgnoreCase(String name);
    boolean existsByPhoneNumber(String phoneNumber);
    
}
