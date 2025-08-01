package com.amar.POMclasses;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class addNewUserPage {

	Page page;
	Locator selectRoll;
	Locator FullName;
	Locator Email;
	Locator MobileNumber;
	Locator Whatsapp;
	Locator saveButton;
	
	
	public addNewUserPage(Page page) {
		this.page=page;
		selectRoll = page.getByPlaceholder("Select Role");
	    FullName = page.getByPlaceholder("Full Name");
		Email = page.getByPlaceholder("Email");
		MobileNumber = page.getByPlaceholder("Mobile Number");
		Whatsapp = page.getByPlaceholder("Whatsapp");
		saveButton = page.getByTestId("save");
	}
	
	public void selectRoll(String valu) {
		selectRoll.selectOption(valu);
	}
	
	public void fullName(String name) {
		 FullName.fill(name);
	}
	
	public void Email(String name) {
		 Email.fill(name);
	}
	
	public void mobileNumber(String name) {
		 MobileNumber.fill(name);
	}
	
	public void watsaap(String name) {
		 Whatsapp.fill(name);
	}
	
	public Locator saveButton() {
		return saveButton;
	}
	
}
