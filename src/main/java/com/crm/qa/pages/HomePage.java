package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//*[@id=\"top-header-menu\"]/div[2]/span[2]/a")
	WebElement FreeAccount;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[2]")
	WebElement homeIcon;
	
	//initializing page objects
	
}
