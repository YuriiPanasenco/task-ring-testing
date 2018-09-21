package com.jdev.taskring.modal;


import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.Select;

import com.jdev.taskring.element.CKEDITOR;
import com.jdev.taskring.element.GridUserList;
import com.jdev.taskring.model.User;



public class TaskDialogModal extends Modal{


	public TaskDialogModal() {
		
	}
	
	public void setAction(String text) {
		CKEDITOR action = new CKEDITOR("#cke_task-action");
		action.setText(text);
	}
	
	public void setLocation(String text) {
		CKEDITOR location = new CKEDITOR("#cke_task-location");
		location.setText(text);
	}
	
	public void setP1(String value) {
		Select dropdown = new Select(driver.findElement(By.id("task-p3")));
		dropdown.selectByVisibleText(value);
	}
	
	public void setP2(String value) {
		Select dropdown = new Select(driver.findElement(By.id("task-p2")));
		dropdown.selectByVisibleText(value);
	}
	
	public void setP3(String value) {
		Select dropdown = new Select(driver.findElement(By.id("task-p1")));
		dropdown.selectByVisibleText(value);
	}
	
	public void setOwner(final String name) throws NotFoundException{
		GridUserList gul = new GridUserList("btn-next_in_discussion_array", "table-for-next_in_discussion_array");
		List<User> users = gul.getUserNamesList();
		System.out.println(users);
		for (User user : users) {
			if(user.getName().equals(name)) {
				gul.setUser(user);
				return;
			}
		}
		throw new NotFoundException("User not found!");
	}
	
	public void pushSaveButton() {
		driver.findElement(By.id("btn-save-task")).click();
	}
}
