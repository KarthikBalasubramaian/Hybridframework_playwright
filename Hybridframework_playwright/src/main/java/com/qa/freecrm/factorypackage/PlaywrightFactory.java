package com.qa.freecrm.factorypackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {


	Playwright playwright;
	Properties prop;
	Browser browser;
	BrowserContext browserContext;
	Page page;


	/*
	 * Initializing Thread Local method to locally store the playwright,browser,
	 * browsercontext and page for better parallel execution.
	 */

	private static ThreadLocal<Playwright> tlplaywright = new ThreadLocal<Playwright>();
	private static ThreadLocal<Browser> tlbrowser = new ThreadLocal<Browser>();
	private static ThreadLocal<BrowserContext> tlbrowsercontext = new ThreadLocal<BrowserContext>();
	private static ThreadLocal<Page> tlpage = new ThreadLocal<Page>();

	public static Playwright getplaywright() {
		return tlplaywright.get();
	}
	
	public static Browser getbrowser() {
		return tlbrowser.get();
	}
	
	public static BrowserContext getbrowsercontext() {
		return tlbrowsercontext.get();
	}
	
	public static Page getpage() {
		return tlpage.get();
	}

	/*
	 * This Method is used to initialize browser
	 */

	public Page initbrowser(Properties prop) {

		String browsername = prop.getProperty("browser").trim();

		tlplaywright.set(Playwright.create());

		switch(browsername.toLowerCase()) {
		case("chromium"):
			tlbrowser.set( getplaywright().chromium().launch(new LaunchOptions().setHeadless(false)));
		break;
		case("firefox"):
			tlbrowser.set( getplaywright().firefox().launch(new LaunchOptions().setHeadless(false)));
		break;
		case("safari"):
			tlbrowser.set(getplaywright().webkit().launch(new LaunchOptions().setHeadless(false)));
		break;
		case("chrome"):
			tlbrowser.set(getplaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
		break;

		default:
			throw new IllegalArgumentException("Unsupported browser  :" + browsername);
		}

		tlbrowsercontext.set(getbrowser().newContext()); 
		tlpage.set(getbrowsercontext().newPage());
		getpage().navigate(prop.getProperty("url"));
		return getpage();


	}

	/*
	 * This method is used to initialize properties
	 */

	public Properties initprop() {
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

