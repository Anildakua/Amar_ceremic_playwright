package com.amar.utilityClasses;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class playwrightFactory {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	public Page initBrowser(String browserName) {
		
		String headLessMode=prop.getProperty("head_less_mode");
		boolean value = Boolean.parseBoolean(headLessMode);
		
		System.out.println("Browser name : "+browserName);

		playwright=Playwright.create();
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new LaunchOptions().setHeadless(value));
			break;
		case "edge":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(value));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(value));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false));
			break;
		default:
			System.out.println("....please enter currect browser name.....");
			break;
		}
		
		browserContext = browser.newContext();
		page=browserContext.newPage();
		
		return page;
	}
	
	/*
	 * 	this method is use to initialize the properties file  
	 */
	
	public Properties initProperties() {
		
		try {
			FileInputStream file=new FileInputStream("./src/test/resources/config/config.proparties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

}
