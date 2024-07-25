package com.example.todolist.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table
public class item {
	private Long id;
	private String task;
	private boolean status;
	
	public item(Long id, String task, boolean status) {
		super();
		this.id = id;
		this.task = task;
		this.status = status;
	}
	
	public item() {
		super();
	}
	@Id
	@SequenceGenerator( name="item_sequence",
			sequenceName="item_sequence",
			allocationSize=1				)
	@GeneratedValue(
		strategy=GenerationType.SEQUENCE,
		generator="item_sequence"	)

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
