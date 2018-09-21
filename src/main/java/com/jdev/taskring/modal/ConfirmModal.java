package com.jdev.taskring.modal;

import org.openqa.selenium.By;

public class ConfirmModal extends Modal{
	
	public void confirm() {
		app.getContext().findElement(By.className("confirm")).click();
	}
	
	public void cancle() {
		app.getContext().findElement(By.className("cancel")).click();
	}
}
