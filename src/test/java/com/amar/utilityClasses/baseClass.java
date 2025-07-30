package com.amar.utilityClasses;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.amar.POMclasses.addNewUserPage;
import com.amar.POMclasses.homePage;
import com.amar.POMclasses.loginPage;
import com.microsoft.playwright.Page;


public class baseClass {

	public Page page;
	playwrightFactory pf;
	protected Properties prop;
	protected ExcelUtils excel;
	protected loginPage login;
	protected homePage home;
	protected addNewUserPage addUser;
	
	
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
		pf.screanShort();
	}
	
	@AfterClass
	public void afterClass() {
		//page.context().browser().close();
		
	}
}
