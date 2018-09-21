package com.jdev.taskring.model;

public class Task {
	
	int id; 
	
	public Task(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Task) {
			Task object = (Task)obj;
			return object.id == this.id;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ""+this.id; 
	}
}
