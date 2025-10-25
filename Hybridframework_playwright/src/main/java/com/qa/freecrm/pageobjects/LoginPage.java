package com.qa.freecrm.pageobjects;

import com.microsoft.playwright.Page;

public class LoginPage  {
	
	 Page page;
	
	//1. String locators - OR
	private String FreeCRMLogo ="img[class=img-responsive]";
	private String Usernameinput = "input[placeholder=Username]";
	
	
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
	
	}
		
	


