package com.example.ExpenseTracker.expensepack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class expService {
	public static double sum=0;
	
	private expRepo obj; 
	@Autowired
	public expService(expRepo obj) {
		super();
		this.obj = obj;
	}

	public List<expense> dispExp()
	{
		return obj.findAll();
	}
	
	public expense addExp(expense e)
	{
		sum+=e.getAmount();
		return obj.save(e);
	}
	
	public void delExp(Long id)
	{
		
		@SuppressWarnings("deprecation")
		expense x=obj.getById(id);
		double amount=x.getAmount();
		sum-=amount;
		obj.deleteById(id);
	}
	
	public List<expense> selExp(String category) {
        return obj.findByCategory(category);
    }
	public double sumExp()
	{
		return sum;
	}
	
	
}
