package com.amar.POMclasses;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class homePage {
	
	Page page;
	
	Locator dashbord;
	Locator userList;
	Locator communication;
	Locator offer;
	Locator termNCond;
	Locator AddNewUser;
	
	
	public homePage(Page page) {
		this.page=page;
		dashbord=page.locator("//a[@href='http://unosysdev.com/Amar-Ceramic-Test/dashboard']");
		userList=page.locator("//a[@href='http://unosysdev.com/Amar-Ceramic-Test/users']");
		communication=page.locator("//div[normalize-space()='Communication']");
		offer=page.locator("//div[normalize-space()='Offers']");
		termNCond=page.locator("//div[normalize-space()='Terms and Conditions']");
		AddNewUser=page.locator("(//div[@class='card-body'])[1]");
	}
	
	
	public Locator addNewUser() {
		return AddNewUser;
	}
	
	public Locator userList() {
		return userList;
	}

	public Locator communication() {
		return communication;
	}
	
	public Locator offer() {
		return offer;
	}
	
	public Locator termNCond() {
		return termNCond;
	}
	
	public Locator dashbord() {
		return dashbord;
	}
	
	
}
