package com.jdev.taskring.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jdev.taskring.Application;

public class LoginPage extends Page {
	
	
	public static LoginPage openLoginPage() {
		LoginPage loginPage = new LoginPage();
	    app.getContext().get(app.getMainURL());
	      
	    return loginPage;
	}
	
	
	private void setName(String name) {
		WebElement field = app.getContext().findElement(By.id("loginform-username"));
		field.clear();
		field.sendKeys(name);
	}
	
	private void setPassword(String password) {
		WebElement field = app.getContext().findElement(By.id("loginform-password"));
		field.clear();
		field.sendKeys(password);
	}
	
	private void pushLoginBytton() {
		WebElement field = app.getContext().findElement(By.tagName("button"));
		field.click();
	}
	
	private void LoginAs(String name, String password) {
		this.setName(name);
		this.setPassword(password);
		this.pushLoginBytton();
	}
	
	public GridPage login(String name, String password) {
		LoginAs(name, password);
		return new GridPage();
	}
	
}
