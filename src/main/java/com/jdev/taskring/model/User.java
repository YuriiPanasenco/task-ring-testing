package com.jdev.taskring.model;

public class User {
	
	private int id;
	
	private String name;
	
	public User(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User user = (User)obj;
			return user.id == this.id && user.name == this.name;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return id+"-"+name;
	}
}
