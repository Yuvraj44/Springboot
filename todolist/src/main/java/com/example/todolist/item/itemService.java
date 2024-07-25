package com.example.todolist.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class itemService {
	private final itemRepo obj;
	@Autowired
	public itemService(itemRepo obj) {
		super();
		this.obj = obj;
	}
	
	
	public List<item> getitems()
	{
		return obj.findAll();
	}
	
	public item save_item(item i)
	{
		return obj.save(i);
	}
	
	public item upd_item(item i)
	{
		return obj.save(i);
	}
	
	public void del_item(Long id)
	{
		obj.deleteById(id);
	}
}
