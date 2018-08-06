package com.cisco.collabNextGen.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cisco.collabNextGen.common.DriverManager;

public class LoginPage extends HomePage {
	@FindBy(id="username")
	private WebElement userNameEdt;

	@FindBy(id="password")
	private WebElement passwordEdt;

	@FindBy(xpath=".//*[text()='Login']")
	private WebElement loginbtn;
    HomePage homepage=new HomePage();
	public LoginPage(WebDriver driver){

		PageFactory.initElements(driver,this);

	}

	public void login(String uname , String pwd) throws InterruptedException{

		userNameEdt.clear();
		passwordEdt.clear();
		userNameEdt.sendKeys(uname);
		log.info("Entered Username");
		Thread.sleep(1000);
		passwordEdt.sendKeys(pwd);
		Thread.sleep(1000);
		log.info("Entered password");
		loginbtn.click();
		Thread.sleep(2000);

		log.info("Clicked on login Button");
		
		}

}
