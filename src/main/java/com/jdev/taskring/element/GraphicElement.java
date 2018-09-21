package com.jdev.taskring.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jdev.taskring.Application;

public abstract class GraphicElement {
	protected static WebDriver driver = Application.getInstance().getContext();
	
}
