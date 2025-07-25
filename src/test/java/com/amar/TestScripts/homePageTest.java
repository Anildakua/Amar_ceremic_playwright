package com.amar.TestScripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.amar.constants.appConstans;
import com.amar.utilityClasses.baseClass;

public class homePageTest extends baseClass {
	
	@Test(priority = 0)
	public void navigateToTheHomePage() {
		
		String currentPageTitel = page.title();
		
		//verifying the current page
		assertEquals(currentPageTitel, appConstans.LOGIN_PAGE_TITLE);
		
		//Entering user name and password
		login.navigateToHomePage(prop.getProperty("user_name")
	               , prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homePageActions() {
		
		home.termNCond().click();
		home.communication().click();
		home.dashbord().click();
	}

}
