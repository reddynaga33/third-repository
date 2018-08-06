package com.cisco.collabNextGen.endtoend.tests;
import java.util.LinkedHashMap;
import org.apache.log4j.Logger;
import org.testng.SkipException;

import org.testng.annotations.Test;

import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.pageobjects.AddDevicePage;
import com.cisco.collabNextGen.pageobjects.AnalysisJobsPage;
import com.cisco.collabNextGen.pageobjects.CollectionJobsPage;
import com.cisco.collabNextGen.pageobjects.ConnectivityPage;
import com.cisco.collabNextGen.pageobjects.DataAnalysisPage;
import com.cisco.collabNextGen.pageobjects.LoginPage;
import com.cisco.collabNextGen.pageobjects.ReportsPage;
import com.cisco.collabNextGen.pageobjects.ScheduleCollectionPage;

public class WorkFlowTest extends BaseTestSuite {
	String defaultAnalysisob="";
	String deviceName1="";
	boolean skipMethod;
	String defaultCollectionJob="";
	LinkedHashMap<String, String> testCaseDetails=excel.getTestCaseData("EndToEnd","ATC01");
	public Logger log = Constants.log;
	
	@Test(priority=0)
	public void loginTest() throws InterruptedException{

		//lauchTheApplication();
		String userName=testCaseDetails.get("UserName");
		String password=testCaseDetails.get("Password");
		getDriver().get(Constants.URL);
		Thread.sleep(2000);
		LoginPage signin = new LoginPage(getDriver());
		signin.login(userName, password);

	}

	@Test(priority=1)
	public void adddeviceAndTestConnectivity() throws InterruptedException {
		
		String deviceName="CUCM_Device";
		Thread.sleep(2000);
		AddDevicePage addObj= new AddDevicePage(getDriver());
		addObj.addDevice_And_Test(deviceName);
		deviceName1=AddDevicePage.str;
	}

	@Test(priority=2)
	public void checkConnectivityStatus() throws InterruptedException{
		Thread.sleep(20000);
		String result=null;
		ConnectivityPage conStatus= new ConnectivityPage(getDriver());
		result=conStatus.navigateToScheduleCollection(getDriver(),deviceName1);
		System.out.println("device connectivity verification is "+result);
		if (result.equals("fail")|| result.equals("connectivitynotdone")){
			skipMethod=true;
		}
	}

	@Test(priority=3, dependsOnMethods="checkConnectivityStatus")
	public void initializeCollection() throws InterruptedException{

		skipMethod("initializeCollection");
		ScheduleCollectionPage init= new ScheduleCollectionPage(getDriver());
		defaultCollectionJob= init.initiateCollection();
		CollectionJobsPage collectionJob= new CollectionJobsPage();
		collectionJob.checkStatusAndstartAnalysis(driver, defaultCollectionJob);
	}

	@Test(priority=4,dependsOnMethods="initializeCollection")
	public void startAnalysisJobTest() throws InterruptedException{
		skipMethod("startAnalysisJobTest");
		String analysisJob=testCaseDetails.get("Analysis_AnalysisJobName").trim();
		String ruleProfile=testCaseDetails.get("Analysis_RuleProfile");
		DataAnalysisPage dataAnalysisObj= new DataAnalysisPage(getDriver());
		dataAnalysisObj.startAnalysis(getDriver(),defaultCollectionJob, analysisJob, ruleProfile);
		defaultAnalysisob=dataAnalysisObj.defaultAnalysisJob;
		AnalysisJobsPage analysisJobObj= new AnalysisJobsPage(getDriver());

		analysisJobObj.startReporting(getDriver(), defaultAnalysisob);

	}

	@Test(priority=5,  dependsOnMethods="startAnalysisJobTest")
	public void startReportTest() throws InterruptedException{
		skipMethod("startReportTest");
		String reportFormat=testCaseDetails.get("Report_ReportFormat");
		ReportsPage reportObj = new ReportsPage();
		reportObj.downloadReport(getDriver(),defaultAnalysisob,reportFormat);
	}


	/*
	 * This method skips the execution if the result is failed
	 */
	public void skipMethod(String methodName){
		if(skipMethod==true){throw new SkipException(methodName+" method is skipped");}
	}
}
