package com.cisco.collabNextGen.analysis.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cisco.collabNextGen.common.BaseTestSuite;


public class StartAnalysisTest extends BaseTestSuite{

	public Map<String, String> header;
	@BeforeMethod
	public void beforeLogin() {
	
	}

	@Test(priority=1,groups = { "smoke", "positive" })
	public void ValidateGetCollectedDataSet() {

		getReportLoggerTest().log(Status.INFO, "TC01: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		getReportLoggerTest().log(Status.INFO, "XXXXXXXXXXXXXXXXXX");
		
		
	}

	@Test(priority=2,groups = { "regression", "positive", "moderate" })
	public void loginValidTest() {

	
	}

	//@Test(priority=3)
	public void loginInValidTest() throws IOException{
	
	}



}
