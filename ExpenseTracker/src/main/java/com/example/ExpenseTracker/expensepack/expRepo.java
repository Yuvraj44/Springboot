package com.example.ExpenseTracker.expensepack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface expRepo extends JpaRepository<expense, Long>{
	List<expense> findByCategory(String category);
}
