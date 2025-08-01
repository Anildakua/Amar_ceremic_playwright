package com.amar.TestScripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.amar.constants.appConstans;
import com.amar.utilityClasses.baseClass;
import com.amar.utilityClasses.listnerClass;
import com.amar.utilityClasses.playwrightFactory;

@Listeners(listnerClass.class)
public class homePageTest extends baseClass {
	
	@Test(priority = 0)
	public void navigateToTheHomePage() {
		
		String currentPageTitel = page.title();
		
		log.info("verifying the current page");
		assertEquals(currentPageTitel, appConstans.LOGIN_PAGE_TITLE);
		
		login.navigateToHomePage(prop.getProperty("user_name")
	               , prop.getProperty("password"));
		log.info("Entered user name and password");
	}
	
	@Test(priority = 1)
	public void homePageActions() {
		
		home.termNCond().click();
		home.communication().click();
		home.dashbord().click();
	}

	@Test(priority = 2)
	public void addNewUser() {
		
		home.addNewUser().click();
		addUser.selectRoll(excel.initExcelsheet("Sheet1", 1, 5));
		addUser.fullName(excel.initExcelsheet("Sheet1", 1, 1));
		//playwrightFactory.screanShort("path.png");
	}
	
}
