package com.cisco.collabNextGen.collector.tests;

import org.testng.annotations.Test;

import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.pageobjects.ConnectivityPage;

public class ConnectivityTest extends BaseTestSuite {
	
	@Test
	
	public void checkConnectivityStatus() throws InterruptedException{
		String  devicename="";
	getDriver().get(Constants.URL);
	ConnectivityPage conStatus= new ConnectivityPage(getDriver());
	
	conStatus.navigateToScheduleCollection(getDriver(),devicename);

}
}