package com.example.CallerLog.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long>{
	List<Contact> findByPhoneNumber(String phoneNumber);
    List<Contact> findByNameContainingIgnoreCase(String name);
}

