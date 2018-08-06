package com.cisco.collabNextGen.collector.tests;

import org.testng.annotations.Test;

import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.pageobjects.AddDevicePage;
import com.cisco.collabNextGen.pageobjects.ConnectivityPage;
import com.cisco.collabNextGen.pageobjects.LoginPage;
import com.cisco.collabNextGen.pageobjects.ScheduleCollectionPage;

public class CollectorEndToEnd extends BaseTestSuite {

	@Test(priority=0)
	public void loginTest() throws InterruptedException{
		
		//lauchTheApplication();
		getDriver().get(Constants.URL);
		Thread.sleep(2000);
		 LoginPage signin = new LoginPage(getDriver());
		 signin.login("admin", "admin123");
		
	}
	
	@Test(priority=1)
	  public void adddeviceAndTestConnectivity() throws InterruptedException {
		  Thread.sleep(5000);
		  AddDevicePage addObj= new AddDevicePage(getDriver());
		  Thread.sleep(5000);
		  String devicename = null ;
		addObj.addDevice_And_Test(devicename);
	  }
	
@Test(priority=2)
	
	public void checkConnectivityStatus() throws InterruptedException{
		Thread.sleep(20000);
		String  devicename="";
	ConnectivityPage conStatus= new ConnectivityPage(getDriver());
	
	conStatus.navigateToScheduleCollection(getDriver(),devicename);

}

@Test(priority=3)
public void initializeCollection() throws InterruptedException{
	
ScheduleCollectionPage init= new ScheduleCollectionPage(getDriver());
init.initiateCollection();

}
}
