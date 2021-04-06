package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory-Object repository
	
	@FindBy(name="login")
	WebElement login;
	
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

//	@FindBy(xpath = "//input[@class='ui fluid large blue submit button']")
//	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpbtn;

	//initializing page objects
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage(); //this method is returning homepage class objects coz clicking click btn it is redirecting to Homepepage
		
	}
	
}
