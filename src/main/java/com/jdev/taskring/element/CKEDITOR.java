package com.jdev.taskring.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CKEDITOR extends GraphicElement{
	
	private WebElement iframe;
	
	public CKEDITOR(String selector) {
		iframe = driver.findElement(By.cssSelector(selector+" iframe"));
	}
	
	
	public void setText(String text) {
		driver.switchTo().frame(iframe);
		WebElement tinymce = driver.findElement(By.tagName("body"));
		tinymce.sendKeys(text);
		driver.switchTo().parentFrame();
	}
	
}
