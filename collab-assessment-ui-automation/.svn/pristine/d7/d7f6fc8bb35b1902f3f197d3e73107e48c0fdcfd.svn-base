package com.cisco.collabNextGen.collector.tests;

import org.testng.annotations.Test;

import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.pageobjects.ScheduleCollectionPage;

public class ScheduleCollectionTest extends BaseTestSuite {
	
	@Test
	public void initializeCollection() throws InterruptedException{
		getDriver().get(Constants.URL);
	ScheduleCollectionPage init= new ScheduleCollectionPage(getDriver());
	init.initiateCollection();
	
	}
			
}
