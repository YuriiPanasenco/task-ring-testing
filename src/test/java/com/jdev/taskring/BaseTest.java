package com.jdev.taskring;

import org.junit.After;
import org.junit.Before;

import com.jdev.taskring.page.GridPage;
import com.jdev.taskring.page.LoginPage;

public class BaseTest {
	
	protected GridPage gridPage;

	@Before
	public void init() {
		Application.getInstance().getContext().manage().deleteAllCookies();
		String userName = "Victor";
        String password = "qwerty";
        LoginPage loginPage = LoginPage.openLoginPage();
        gridPage = loginPage.login(userName, password);
	}
	
	@After
	public void end() {
		gridPage.logout();
	}
	
	
	protected void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
