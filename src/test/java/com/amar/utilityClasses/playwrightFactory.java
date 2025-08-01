package com.amar.utilityClasses;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class playwrightFactory {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	static Page page;
	Properties prop;
	
	private static ThreadLocal<Browser> tlbrowser=new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlbrowserContext=new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlplaywright=new ThreadLocal<>();
	private static ThreadLocal<Page> tlpage=new ThreadLocal<>();
	
	public static  Playwright getPlaywright() {
		return tlplaywright.get();
	}
	
	public static  Browser getBrowser() {
		return tlbrowser.get();
	}
	
	public static  BrowserContext getBrowserContext() {
		return tlbrowserContext.get();
	}
	
	public static  Page getPage() {
		return tlpage.get();
	}
	
	public Page initBrowser(String browserName) {
		
		// To get the browser run mode
		String headLessMode=prop.getProperty("head_less_mode");
		boolean value = Boolean.parseBoolean(headLessMode);
		
		System.out.println("Browser name : "+browserName);

		//playwright=Playwright.create();
		tlplaywright.set(Playwright.create());
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			//browser = playwright.chromium().launch(new LaunchOptions().setHeadless(value));
			tlbrowser.set( getPlaywright().chromium().launch(new LaunchOptions().setHeadless(value)));
			break;
		case "edge":
			//browser = playwright.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(value));
			tlbrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(value)));
			break;
		case "chrome":
			//browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(value));
			tlbrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(value)));
			break;
		case "firefox":
			//browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false));
			tlbrowser.set(getPlaywright().firefox().launch(new LaunchOptions().setHeadless(value)));
			break;
		case "safari":
			//browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false));
			tlbrowser.set(getPlaywright().webkit().launch(new LaunchOptions().setHeadless(false)));
			break;
		default:
			System.out.println("....please enter currect browser name.....");
			break;
		}
		
		//browserContext = browser.newContext();
		tlbrowserContext.set(getBrowser().newContext());
		//page=browserContext.newPage();
		tlpage.set(getBrowserContext().newPage());
		return getPage();
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
	
	
	/*
	 *  takes screanshot method 
	 */
	
	public static String screanShort(String path) {
		
		try {
			getPage().screenshot(new ScreenshotOptions()
					.setPath(Path.of(path))
					.setFullPage(true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
	
  

