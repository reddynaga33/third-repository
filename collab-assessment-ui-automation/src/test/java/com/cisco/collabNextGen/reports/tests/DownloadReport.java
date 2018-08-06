package com.cisco.collabNextGen.reports.tests;

import org.testng.annotations.Test;

import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.pageobjects.AddDevicePage;
import com.cisco.collabNextGen.pageobjects.HomePage;
import com.cisco.collabNextGen.pageobjects.LoginPage;
import com.cisco.collabNextGen.pageobjects.ReportsPage;




public class DownloadReport extends BaseTestSuite {
	
	
	

	@Test(priority=0)
	public void loginTest() throws InterruptedException{

		//lauchTheApplication();
		getDriver().get(Constants.URL);
		Thread.sleep(2000);
		LoginPage signin = new LoginPage(getDriver());
		signin.login("admin", "admin1234");

	}

	@Test(priority=2)
	public void adddeviceAndTestConnectivity() throws InterruptedException {
		
		Thread.sleep(2000);
		HomePage homePage= new HomePage(getDriver());
		//homePage.navigateToAnyModule();
		homePage.navigateToAnyElement();
		
		ReportsPage reports=new ReportsPage(getDriver());
		reports.downloadReport(driver, analysisJobName, reportFormat);
		
	
		
	}
	
	
	
	@Test(priority=2)
	public void DownloadReport() throws InterruptedException {
		
		Thread.sleep(2000);
		HomePage homePage= new HomePage(getDriver());
		//homePage.navigateToAnyModule();
		homePage.navigateToAnyElement();
		
    		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
