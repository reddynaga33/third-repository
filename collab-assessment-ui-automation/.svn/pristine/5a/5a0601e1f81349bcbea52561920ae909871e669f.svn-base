package com.cisco.collabNextGen.collector.tests;

import org.testng.annotations.Test;

import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.endtoend.tests.LoginTest;
import com.cisco.collabNextGen.pageobjects.AddDevicePage;

public class AddDevicesTest extends BaseTestSuite {
  @Test
  public void adddeviceAndTestConnectivity() throws InterruptedException {
	  String Devicename="";
	  getDriver().get(Constants.URL);
	  Thread.sleep(5000);
	  AddDevicePage addObj= new AddDevicePage(getDriver());
	  Thread.sleep(5000);
	  addObj.addDevice_And_Test(Devicename);
  }
}
