package com.cisco.collabNextGen.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cisco.collabNextGen.common.CommonReusables;
import com.cisco.collabNextGen.utilities.LoggerLib;
import com.cisco.collabNextGen.utilities.WebDriverUtilities;

public class CollectionJobsPage extends HomePage {
	
	

	public CommonReusables commonRU = new CommonReusables();
	public WebDriverUtilities webDriveLib= new WebDriverUtilities();
	public String defaultAnalysisJob="";
	
	/**
	 * Logger instance
	 */
	public Logger log = LoggerLib.writeLog(this.getClass().getName());
	
	public boolean checkStatusAndstartAnalysis(WebDriver driver,String collectionJobName) throws InterruptedException{
		try{
			Thread.sleep(5000);
		commonRU.filterColumn(driver, "Task Name", collectionJobName);
		String status=commonRU.verifyStatus(driver, "Collection Jobs", collectionJobName);
		if(status.equalsIgnoreCase("Completed")){
			commonRU.switchToFrameSSUEMain(driver);
			driver.findElement(By.xpath("//div[div[a[text()='"+collectionJobName+"']]]/following-sibling::div//a[text()='Start Analysis']"));	
		}
		}catch (Exception e) {
			log.error("Error in Collection Job");
			e.printStackTrace();
			return false;
			
		}
		log.info("Collection Job Done");
		return true;
		}
	
	}

