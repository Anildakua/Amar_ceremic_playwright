package com.amar.POMclasses;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class loginPage {
	
	private Page page;
	private Locator username;
	private Locator Password;
	private Locator button;
	
	public loginPage(Page page) {
		this.page=page;
		username=page.locator("//input[@id='email']");
		Password=page.locator("//input[@id='password']");
		button=page.locator("button[type='submit']");
	}
	
	
	
	public homePage navigateToHomePage(String username,String password) {
		 this.username.fill(username);
		 this.Password.fill(password);
		 button.click();
		 return new homePage(page);
	}

	public String getLoginPageTitle() {
		String loginTitel = page.title();
		return loginTitel;
	}
}
