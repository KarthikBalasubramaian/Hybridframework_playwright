package com.qa.freecrm.factorypackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	Properties prop;
	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	
	public Page intibrowser(Properties prop) {
		
		String browsername = prop.getProperty("browser").trim();
		System.out.println("Browser name is "+browsername);
		
		playwright = Playwright.create();
		
		switch (browsername.toLowerCase())
		{
		case "chromium":
			browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
			break;

		case "firefox":
			browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false));
			break;
			
		case "safari":
			browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false));
			break;
			
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser"+ browsername);
		}
		
		browsercontext =  browser.newContext();
		page = browsercontext.newPage();
		page.navigate(prop.getProperty("url"));
		return page;
		
	}
	
	/*
	 * This method is used to initialize the properties from config file
	 * 
	 */
	
	public Properties InitProperties() {
		
		try {
			FileInputStream ip = new FileInputStream(".\\src\\test\\resource\\config\\config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
