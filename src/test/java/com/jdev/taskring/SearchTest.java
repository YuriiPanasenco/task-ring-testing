package com.jdev.taskring;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jdev.taskring.page.GridPage;
import com.jdev.taskring.page.LoginPage;

public class SearchTest extends BaseTest{

	@Test
	public void testSearchSpecChart() throws Exception {
		gridPage.search("some'",null,null);
		assertFalse(gridPage.hasError());
	}
	
}
