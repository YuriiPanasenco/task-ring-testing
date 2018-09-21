package com.jdev.taskring.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.jdev.taskring.modal.ConfirmModal;
import com.jdev.taskring.modal.TaskDialogModal;
import com.jdev.taskring.model.Task;

public class GridPage extends Page{

	private WebElement table = app.getContext().findElement(By.id("main-task-table"));
	
	public String getLoggedinUserName() {
		return app.getContext().findElement(By.id("toolbar-user")).getText();
	}
	
	public void search(String search, String user, String view) {
		app.getContext().findElement(By.id("search-query-input")).sendKeys(search);
		app.getContext().findElement(By.id("search-query-input")).sendKeys(Keys.ENTER);
	}
	
	public TaskDialogModal pushCreateButton() {
		app.getContext().findElement(By.id("btn-create-task")).click();
		try {
			Thread.sleep(500);
		}catch (Exception e) {
			System.err.println(e);
		}
		return new TaskDialogModal();
	}
	
	public List<Task> getTasks(){
		List<Task> res = new ArrayList<Task>();
		List<WebElement> elements = table.findElements(By.tagName("tr"));
		for (WebElement webElement : elements) {
			String key = webElement.getAttribute("data-key");
			try {
				res.add(new Task(Integer.parseInt(key)));
			}catch (NumberFormatException e) {
				//TODO WTF?
				System.out.println(webElement.getText());
			}
		}
		return res;
	}
	
	public void selectTask(Task task) {
		table.findElement(By.cssSelector("tr[id=\""+task.getId()+"\"]"));
	}
	
	public ConfirmModal pushDeleteButton() {
		app.getContext().findElement(By.id("btn-delete-task")).click();
		return new ConfirmModal();
	}
	
	public void logout() {
		WebElement logoutButton = app.getContext().findElement(By.className("glyphicon-log-out"));
		logoutButton.click();
	}
}
