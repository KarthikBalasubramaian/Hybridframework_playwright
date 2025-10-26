package com.qa.freecrm.pageobjects;

import com.microsoft.playwright.Page;

public class LoginPage  {
	
	 Page page;
	
	//1. String locators - OR
	private String FreeCRMLogo ="img[class=img-responsive]";
	private String UsernameInput = "input[placeholder=Username]";
	private String PasswordInput = "//input[@type='password']";
	private String Loginbutton = "//div[@class='input-group-btn']//input[@type='submit']";
	
	
	//2.Page constructor:
	public LoginPage(Page page) {
		this.page = page;
	}
	
	//3.page action/methods:
	
	public String GetHomePageTitle() {
		String ActualTitle = page.title(); 
		return ActualTitle;
	}
	
	public String GetHomePageUrl() {
		String ActualLoginPageUrl = page.url();
		return  ActualLoginPageUrl;
	}
	
	
	public Homepage LogInToFreeCrmPage(String username, String Password) {
     page.fill(UsernameInput, username);
     page.fill(PasswordInput, Password);
     page.click(Loginbutton);
     return new Homepage(page);
     
	}
	
	public boolean FreeCrmLogoVisiblityCheck() {
		return page.isVisible(FreeCRMLogo);
		
	}
	
	}
		
	


