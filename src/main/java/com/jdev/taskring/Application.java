package com.jdev.taskring;

import java.util.concurrent.TimeUnit;

import org.openqa.grid.internal.cli.StandaloneCliOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.server.SeleniumServer;

public class Application {
	private static Application instance;
	
	private static final WebDriver driver;
	
	private String mainUrl="http://mlc.taskringtest.com";
	
	static {
		final StandaloneCliOptions options = new StandaloneCliOptions();
		final SeleniumServer seleniumServer = new SeleniumServer(options.toConfiguration());;
		seleniumServer.boot();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		instance = new Application();
	}
	
	public Application() {
		driver.get(this.mainUrl);
	}
	
	public static Application getInstance() {
		return instance;
	}
	
	public void close() {
		driver.quit();
	}
	
	public WebDriver getContext() {
		return driver;
	}
	
	public synchronized void setMainURL(String url) {
		this.mainUrl=url;
		driver.get(url);
	}
	
	public synchronized String getMainURL() {
		return this.mainUrl;
	}
	
}
