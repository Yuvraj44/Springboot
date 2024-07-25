package com.example.ExpenseTracker.expensepack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class expController {
	private expService obj;
	@Autowired
	public expController(expService obj) {
		super();
		this.obj = obj;
	}
	
	@GetMapping("/")
	public List<expense> disp()
	{
		return obj.dispExp();
	}
	
	@GetMapping(path="/{key}")
	public List<expense> selDisp(@PathVariable("key") String s)
	{
		return obj.selExp(s);
	}
	
	@PostMapping("/")
	public expense add(@RequestBody expense e)
	{
		return obj.addExp(e);
	}
	
	@DeleteMapping(path="/{id}")
	public void del(@PathVariable("id") Long id)
	{
		obj.delExp(id);
	}
	@GetMapping("/sum")
	public double sum()
	{
		return obj.sumExp();
	}
}
