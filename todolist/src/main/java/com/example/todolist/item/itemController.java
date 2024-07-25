package com.example.todolist.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping
@RestController
public class itemController {
	
	private itemService obj;
	@Autowired
	public itemController(itemService obj) {
		super();
		this.obj = obj;
	}
	
	
	@GetMapping("/")
	public List<item> disp()
	{
		return obj.getitems();
	}
	
	@PostMapping("/")
	public item add(@RequestBody item i)
	{
		return obj.save_item(i);
	}
	
	@PutMapping("/")
	public item update(@RequestBody item i)
	{
		return obj.upd_item(i);
	}
	
	@DeleteMapping(path="/{id}")
	public void del(@PathVariable("id") Long i)
	{
		i=1L;
		obj.del_item(i);
	}
}
