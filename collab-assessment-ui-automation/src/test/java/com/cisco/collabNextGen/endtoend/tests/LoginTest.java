package com.cisco.collabNextGen.endtoend.tests;

import org.testng.annotations.Test;


import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.common.DriverManager;
import com.cisco.collabNextGen.pageobjects.LoginPage;



public class LoginTest extends BaseTestSuite {
	
	@Test(priority=0)
	public void loginTest() throws InterruptedException{
		
		//lauchTheApplication();
		System.out.print("its has started");
		getDriver().get(Constants.URL);
		//Thread.sleep(2000);
		// LoginPage signin = new LoginPage(getDriver());
		// signin.login("admin", "admin123");
		
	}
	
}
