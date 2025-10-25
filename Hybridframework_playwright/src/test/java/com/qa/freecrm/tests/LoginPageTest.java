package com.qa.freecrm.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.qa.freecrm.basetest.basetest;
import com.qa.freecrm.constants.Appconstants;


public class LoginPageTest extends basetest{
	
	public LoginPageTest() {
		super();
		
	}
	
	
	
	@Test
	public void VerifyLoginPageTitle() {
		assertEquals(loginPage.GetHomePageTitle(), Appconstants.LOGIN_PAGE_TITLE, "The actual title does not match the expected title");
	}
	
	@Test
	public void VerifyLoginPageUrl() {
		assertEquals(loginPage.GetHomePageUrl(),prop.getProperty("url"),"The actual url does not match the expected url");
	}
	
	
	
	
	

}
