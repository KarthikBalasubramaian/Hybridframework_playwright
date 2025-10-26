package com.qa.freecrm.basetest;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.freecrm.factorypackage.PlaywrightFactory;
import com.qa.freecrm.pageobjects.Homepage;
import com.qa.freecrm.pageobjects.LoginPage;

public class basetest {
	
	PlaywrightFactory playwrightFactory;
	protected Properties prop;
	Page page;
	protected LoginPage loginPage;
	protected Homepage homepage;
	
	@BeforeTest
	public void Setup() {
		playwrightFactory = new PlaywrightFactory();
		prop = playwrightFactory.initprop();
		page =playwrightFactory.initbrowser(prop);
		loginPage = new LoginPage(page);
		
	}
	
	@AfterTest
	public void Teardown() {
		page.context().browser().close();
		
	}
	

}
