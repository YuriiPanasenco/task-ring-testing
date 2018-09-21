package com.jdev.taskring.element;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import com.jdev.taskring.model.User;

public class GridUserList extends GraphicElement {

	private static final String EMPTY = "---";
	
	
	private String textBlockId;
	private String tableId;
	
	public GridUserList(String textBlockId, String tableId) {
		this.textBlockId=textBlockId;
		this.tableId=tableId;
		open();
	}
	
	public void open() {
		driver.findElement(By.id(textBlockId)).click();
		try {
			Thread.sleep(200);
		}catch (Exception e) {
			
		}
	}
	
	public List<User> getUserNamesList() throws NotFoundException{
		ArrayList<User> result = new ArrayList<User>();
		
		List<WebElement> tds = driver.findElements(By.cssSelector("#"+this.tableId+" td"));
		
		for (WebElement td : tds) {
			String tdText = td.getText();
			if(tdText.equals(EMPTY)) {
				continue;
			}
			String attributevalue = td.getAttribute("data-user_id");
			if(attributevalue==null) {
				throw new NotFoundException("Attribute data-user_id not found!");
			}
			int id = Integer.parseInt(attributevalue);
			
			result.add(new User(id, tdText));
		}
		return result;
	}

	public void setUser(User user) {
		driver.findElement(By.cssSelector("#"+this.tableId+" td[data-user_id='"+user.getId()+"']")).click();
	}
}
