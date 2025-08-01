package com.amar.TestScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amar.constants.appConstans;
import com.amar.utilityClasses.baseClass;
import com.amar.utilityClasses.listnerClass;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Listeners(listnerClass.class)
public class loginPageTest extends baseClass {

	@Test
	public void login() {
		
		log.info("Landing into login page ");
		//Entering user name and password
		login.navigateToHomePage(prop.getProperty("user_name")
				               , prop.getProperty("password"));
		
		assertThat(page).hasTitle(appConstans.HOME_PAGE_TITLE);//verifying the login is sucssefully log  
		log.info("successfully we loged in it to dashbord page");
	}
}
