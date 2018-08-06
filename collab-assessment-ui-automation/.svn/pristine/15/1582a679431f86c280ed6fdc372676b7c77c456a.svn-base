package com.cisco.collabNextGen.analysis.tests;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cisco.collabNextGen.common.BaseTestSuite;
import com.cisco.collabNextGen.common.CommonReusables;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.pageobjects.AnalysisJobsPage;
import com.cisco.collabNextGen.pageobjects.DataAnalysisPage;
import com.cisco.collabNextGen.pageobjects.LoginPage;
import com.cisco.collabNextGen.utilities.WebDriverUtilities;

public class DataAnalysisTest extends BaseTestSuite{
//	LinkedHashMap<String, String> testCaseDetails=excel.getTestCaseData("Analysis","AATC01");
	WebDriverUtilities webDriveLib= new WebDriverUtilities();
	public CommonReusables commonRU = new CommonReusables(); 
	public Logger log = Constants.log;
	WebDriver driver;
	
	//@Test(priority=1,groups="positive")
	public void verifySubModules() throws InterruptedException{
		LinkedHashMap<String, String> testCaseDetails=excel.getTestCaseData("Analysis","AATC01");
		String moduleName="Analysis";
		LinkedList<String> expectedData=new LinkedList<>();
		driver = getDriver();
		lauchTheApplicationAndLogin("admin", "admin1234");
		DataAnalysisPage dataAnalysisObj= new DataAnalysisPage(getDriver());
		dataAnalysisObj.clickOnModule(getDriver(),moduleName);
		LinkedList<String> actualData=dataAnalysisObj.getModuleSubSections(driver, moduleName);
		expectedData.add(testCaseDetails.get("Parameter1"));
		expectedData.add(testCaseDetails.get("Parameter2"));
		expectedData.add(testCaseDetails.get("Parameter3"));
		boolean flag=commonRU.compareLists(expectedData, actualData);
		Assert.assertTrue(commonRU.compareLists(expectedData, actualData));
	}

	//@Test(priority=1,groups="negetive")
	public void verifyMandatoryFields() throws InterruptedException{
		LinkedHashMap<String, String> testCaseDetails=excel.getTestCaseData("Analysis","AATC02");
		String moduleName="Analysis";
		LinkedList<String> expectedData=new LinkedList<>();
		driver = getDriver();
		lauchTheApplicationAndLogin("admin", "admin1234");
		
		DataAnalysisPage dataAnalysisObj= new DataAnalysisPage(getDriver());
		dataAnalysisObj.clickOnModule(getDriver(),moduleName);
		List<String> actualData=dataAnalysisObj.getAllMandatoryFields(driver);
		expectedData.add(testCaseDetails.get("Parameter1"));
		expectedData.add(testCaseDetails.get("Parameter2"));
		expectedData.add(testCaseDetails.get("Parameter3"));
		boolean flag=commonRU.compareLists(expectedData, actualData);
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1,groups="positive")
	public void verifySelectCollectionJobsPopUP() throws InterruptedException{
		LinkedHashMap<String, String> testCaseDetails=excel.getTestCaseData("Analysis","AATC04");
		String moduleName="Analysis";
		String expectedMessage=null,actualMessage=null,firstCollectionJob=null,secondCollectionJob=null,
				selectedCollectionJob=null,collectionJobAfterChange=null;
		LinkedList<String> expectedData=new LinkedList<>();
		driver = getDriver();
		boolean verifyMessage,menuVerification,verifyFileter;
		//Getting the test data from the excel
		expectedMessage= testCaseDetails.get("Parameter1");
		firstCollectionJob=testCaseDetails.get("Parameter2");
		secondCollectionJob=testCaseDetails.get("Parameter3");
		//Step 1: Launching the application and logging in with credentials 
		lauchTheApplicationAndLogin("admin", "admin1234");
		
		//Step 2: Initiate the Page and navigate to Data Analysis Page 
		DataAnalysisPage dataAnalysisObj= new DataAnalysisPage(getDriver());
		dataAnalysisObj.navigateToDataAnalysis();
		
		//Step 3: Switching to Frame
		commonRU.switchToFrameSSUEMain(driver);
		
		//Step 4: Click on Select Collection Jobs
		dataAnalysisObj.getSelectCollectionJobsWE().click();
		
		actualMessage=dataAnalysisObj.getMessageInCollectionJobPopup().getText();
		SoftAssert multipleVerification= new SoftAssert();
		
		verifyMessage=actualMessage.contains(expectedMessage);
		multipleVerification.assertTrue(verifyMessage, "successfully verified the message for "
				+ "\"successfully Collection Jobs listed\" in the pop up");
		
		//Step 5: Closing the Collection Job Popup for continuance of the Test Script
		dataAnalysisObj.getCloseBtnPopup().click();
		
		//Step 6: Verification of the Grid Menu and Verifying all the menu content with Column Header
		menuVerification=dataAnalysisObj.verifyMenuWithGrid(driver);
		multipleVerification.assertTrue(menuVerification,"Successfully verified the Grid option menu "
				+ "and Successfully verified the Column Headers with the Grid Menu list ");
		
		//Step 7: Verification of Filter for all the columns
		verifyFileter=dataAnalysisObj.verifyFilterInPopup(driver);
		multipleVerification.assertTrue(verifyFileter,"Successfully verified all the filters in the Popup");
		
		//Step 8: Verification for the Selected collection Job
		dataAnalysisObj.selectCollectionJob(driver, firstCollectionJob);
		selectedCollectionJob=dataAnalysisObj.getCollectionJobAfterSelected().getText();
		multipleVerification.assertEquals(firstCollectionJob, selectedCollectionJob, "Successfully Verified the "
				+ "selected collection Job in the Data Analysis Page");
		
		//Step 9: Verification for the change in the Collection Job reflects in the DataAnalysis Page
		dataAnalysisObj.changeCollectionJob(driver, secondCollectionJob);
		collectionJobAfterChange=dataAnalysisObj.getCollectionJobAfterSelected().getText();
		multipleVerification.assertEquals(secondCollectionJob, collectionJobAfterChange, "Successfully Verified the "
				+ "selected collection Job in the Data Analysis Page after change");
		
	}
	
	
	//@Test
	public void verifyDefaultFuctionality() throws InterruptedException{
		LinkedHashMap<String, String> testCaseDetails=excel.getTestCaseData("Analysis","AATC03");
		String moduleName="Analysis";
		LinkedList<String> expectedData=new LinkedList<>();
		driver = getDriver();
		lauchTheApplicationAndLogin("admin", "admin1234");
		DataAnalysisPage dataAnalysisObj= new DataAnalysisPage(getDriver());
		dataAnalysisObj.enterAllFields(driver, testCaseDetails.get("Parameter1"), 
				testCaseDetails.get("Parameter2"), testCaseDetails.get("Parameter3"));
		dataAnalysisObj.clickOnResetBtn();
		boolean x=dataAnalysisObj.verifyResetFunctionality();
		Assert.assertTrue(dataAnalysisObj.verifyResetFunctionality());
	}
	
}	
