package com.qa.freecrm.pageobjects;

import com.microsoft.playwright.Page;
import com.qa.freecrm.constants.Appconstants;

public class Homepage {
	
	Page page;
	
	
	
	private String LogoutButton = "";
	
	
	public Homepage(Page page) {
		this.page= page;
	}
	
	public boolean GetHomePageTitle() {
		String ActualHomePageTitle = page.title();
		if(ActualHomePageTitle.equals(Appconstants.HOME_PAGE_TITLE)) {
			return true;
		}else {
			return false;
		}
		
	}

}
