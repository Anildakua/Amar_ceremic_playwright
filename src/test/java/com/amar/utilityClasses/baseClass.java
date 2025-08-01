package com.amar.utilityClasses;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.amar.POMclasses.addNewUserPage;
import com.amar.POMclasses.homePage;
import com.amar.POMclasses.loginPage;
import com.beust.jcommander.Parameter;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class baseClass {

	public Page page;
	playwrightFactory pf;
	protected Properties prop;
	protected ExcelUtils excel;
	protected loginPage login;
	protected homePage home;
	protected addNewUserPage addUser;
	protected static Logger log;
	
	
	@BeforeClass
	public void beforeClass() {
		pf=new playwrightFactory();
		prop=pf.initProperties();
		page=pf.initBrowser(prop.getProperty("browser"));
		page.navigate(prop.getProperty("url"));
		excel=new ExcelUtils();
		login=new loginPage(page);
		home=new homePage(page);
		addUser=new addNewUserPage(page);
		log=LogManager.getLogger(this.getClass());
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		page.context().browser().close();
		
	}
}
