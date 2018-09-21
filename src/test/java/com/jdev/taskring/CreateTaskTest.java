package com.jdev.taskring;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.jdev.taskring.modal.ConfirmModal;
import com.jdev.taskring.modal.TaskDialogModal;
import com.jdev.taskring.model.Task;

public class CreateTaskTest extends BaseTest{
	
	private List<Task> oldTaskList=null; 
	private Task task = null;
	
	@Test
	public void createTask() {
		oldTaskList = gridPage.getTasks();
		TaskDialogModal tdm = gridPage.pushCreateButton();
		
		tdm.setAction("action");
		tdm.setLocation("location");
		tdm.setP1("4");
		tdm.setOwner("Jim");
		tdm.pushSaveButton();
		pause(2000);
		
		List<Task> newTaskList = gridPage.getTasks();
		newTaskList.removeAll(oldTaskList);		
        assertTrue(newTaskList.size()==1);
        
        this.task=newTaskList.get(0);
	}

	@After
	public void deleteTask() {
		gridPage.selectTask(this.task);
        ConfirmModal confirmModal = gridPage.pushDeleteButton();
        pause(500);
        confirmModal.confirm();
        pause(100);
        List<Task> afterRemove = gridPage.getTasks();
        afterRemove.removeAll(oldTaskList);
        pause(2000);
        assertTrue(afterRemove.isEmpty());
	}
	
}
