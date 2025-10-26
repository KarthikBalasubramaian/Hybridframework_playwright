package com.qa.freecrm.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.qa.freecrm.basetest.basetest;
import com.qa.freecrm.constants.Appconstants;


public class LoginPageTest extends basetest{
		
	
	
	@Test(priority = 1)
	public void VerifyLoginPageTitle() {
		assertEquals(loginPage.GetHomePageTitle(), Appconstants.LOGIN_PAGE_TITLE, "The actual title does not match the expected title");
	}
	
	@Test(priority = 2)
	public void VerifyLoginPageUrl() {
		assertEquals(loginPage.GetHomePageUrl(),prop.getProperty("url"),"The actual url does not match the expected url");
	}
	
	@Test(priority = 3)
	public void VerifySuccessfulLogin() {
		homepage =loginPage.LogInToFreeCrmPage(prop.getProperty("Username"), prop.getProperty("Password"));
		assertTrue(homepage.GetHomePageTitle(), "Login was unsuccessfull");
	}
	
	
	
	
	

}
