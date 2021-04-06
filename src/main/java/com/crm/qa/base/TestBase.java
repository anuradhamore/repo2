package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	// basic initialization

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream("C:\\Users\\anuradha.more\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


public static void initialization() {
	
	String browserName= prop.getProperty("browser");
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver(); //launch chrome
		
		
		}else if (browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Google\\Chrome\\Application\\geckodriver.exe");
			driver = new FirefoxDriver(); //launch Firefox
			
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS );
	
	driver.get(prop.getProperty("url"));
}
}