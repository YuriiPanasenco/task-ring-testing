package com.jdev.taskring.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jdev.taskring.Application;

public class Page {
	protected static Application app = Application.getInstance();
	
	protected WebDriver driver = Application.getInstance().getContext();
	
	public boolean hasError() {
		WebElement errorMessage = app.getContext().findElement(By.className("site-error"));
		return errorMessage!=null;
	}
}
