package com.cisco.collabNextGen.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cisco.collabNextGen.common.CommonReusables;
import com.cisco.collabNextGen.utilities.LoggerLib;
import com.cisco.collabNextGen.utilities.WebDriverUtilities;

public class AnalysisJobsPage extends HomePage {

	CommonReusables commonRU = new CommonReusables();
	WebDriverUtilities webDriveLib= new WebDriverUtilities();
	/**
	 * Logger instance
	 */
	public Logger log = LoggerLib.writeLog(this.getClass().getName());


	@FindBy(xpath = "//div[@class='ssueContainerTitle']/span")
	private WebElement pageNameWE;

	@FindBy(xpath = "//a[text()='Start Reporting']")
	private WebElement startReportLNK;

	public AnalysisJobsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean startReporting(WebDriver driver, String analysisJobName) throws InterruptedException{
		commonRU.verifyStatus(driver,"Analysis Job", analysisJobName);
		commonRU.filterColumn(driver, "Analysis Job Name", analysisJobName);
		log.info("Clicking on Start Reporting link");
		startReportLNK.click();
		return true;
		
	}

	
}
