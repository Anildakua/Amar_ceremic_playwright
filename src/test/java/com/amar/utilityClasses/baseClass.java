package com.amar.utilityClasses;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.amar.POMclasses.homePage;
import com.amar.POMclasses.loginPage;
import com.microsoft.playwright.Page;


public class baseClass {

	public Page page;
	playwrightFactory pf;
	protected Properties prop;
	protected loginPage login;
	protected homePage home;
	
	@BeforeClass
	public void beforeClass() {
		pf=new playwrightFactory();
		prop=pf.initProperties();
		page=pf.initBrowser(prop.getProperty("browser"));
		page.navigate(prop.getProperty("url"));
		
		login=new loginPage(page);
		home=new homePage(page);
	}
	
	@AfterClass
	public void afterClass() {
		page.context().browser().close();
		
	}
}
