package com.example.ExpenseTracker.expensepack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class expense {
	
	@Id
	@SequenceGenerator( name="exp_sequence",sequenceName="exp_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="exp_sequence")

	private Long id;
    private String name;
    private double amount;
    private String category;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
    
    
}
