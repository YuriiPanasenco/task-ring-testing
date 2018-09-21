package com.jdev.taskring;

import org.junit.*;
import static org.junit.Assert.*;

import com.jdev.taskring.page.GridPage;
import com.jdev.taskring.page.LoginPage;

public class LoginUserTest {
	
	@Before
	public void init() {
		Application.getInstance().getContext().manage().deleteAllCookies();
	}
	
	
	@Test
	public void testLoginLogout() throws Exception {
		String userName = "Victor";
        String password = "qwerty";
        LoginPage loginPage = LoginPage.openLoginPage();
        GridPage gridPage = loginPage.login(userName, password);
        assertEquals(userName, gridPage.getLoggedinUserName());
        gridPage.logout();
	}

}
