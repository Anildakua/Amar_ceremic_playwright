package com.amar.TestScripts;

import org.testng.annotations.Test;

import com.amar.constants.appConstans;
import com.amar.utilityClasses.baseClass;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class loginPageTest extends baseClass {

	@Test
	public void login() {
		
		//Entering user name and password
		login.navigateToHomePage(prop.getProperty("user_name")
				               , prop.getProperty("password"));
		
		assertThat(page).hasTitle(appConstans.HOME_PAGE_TITLE);//verifying the login is sucssefully log  
		
	}
}
