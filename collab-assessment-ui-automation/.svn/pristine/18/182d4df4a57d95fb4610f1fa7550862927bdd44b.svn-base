package com.cisco.collabNextGen.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cisco.collabNextGen.common.CommonReusables;
import com.cisco.collabNextGen.common.DriverManager;
import com.cisco.collabNextGen.utilities.WebDriverUtilities;

import sun.util.logging.resources.logging;

public class ConnectivityPage extends HomePage{
	CommonReusables commonRU = new CommonReusables();
	WebDriverUtilities webDriveLib= new WebDriverUtilities();

	@FindBy(xpath= "//span[text()='Device Connectivity']")
	private WebElement DevConnectivity;

	@FindBy(xpath="//span[text()='Device Name']/ancestor::div[@role='columnheader']//input[@aria-label='Filter for column']")
	private WebElement search;

	@FindBy (xpath=".//*[@class='ui-grid-cell-contents'][contains(text(),'CUCM_')]/ancestor::div/div/div/span")
	//div[contains(text(),'Sampledevice')]/ancestor::div/div/div/span[@target='deviceconnectivity']")
	private WebElement connectivityStatus;

	@FindBy(xpath="//iframe[@class='ssueContentIframe ng-scope']")
	private WebElement iframe;
	//div[text()='Cucm_9_1_101']/ancestor::div[contains(@id,'uiGrid')]/following-sibling::div[contains(@class,'connectivity')]")
	

	public ConnectivityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public String navigateToScheduleCollection(WebDriver driver,String deviceName) throws InterruptedException
	{
		DevConnectivity.click();
		log.info("Clicked om device Connectivity");
		Thread.sleep(5000);
		switchToFrameSSUEMain(DriverManager.getTheDriverInstance());
		Thread.sleep(2000);
		search.clear();
		log.info("clicked in search");
		Thread.sleep(1000);
		search.sendKeys(deviceName);

		String status = commonRU.verifyStatus(DriverManager.getTheDriverInstance(),"Device Connectivity",deviceName);

		if(status.equals("passed")){
			startCollection(driver,deviceName);
			log.info("check if the status is passed");
			return "pass";
		}
		else if(status.equals("Failed")||status.equals("failure") ){
			System.out.println("Device connectivity id failed");
			log.info("Checked the status if failed");
			
			return "fail";
			//Assert.assertTrue(false);
		}
		else
		{
			System.out.println("Connectivity not done");
			log.info("Connectivity not done");
			return "connectivitynotdone";
		}

	}


	private void switchToFrameSSUEMain(WebDriver driver) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframe);

	}

	private void startCollection(WebDriver driver,String deviceName)
	{
		commonRU.switchToFrameSSUEMain(driver);
		WebElement wb=driver.findElement(By.xpath("//div[div[text()='"+deviceName+"']]/following-sibling::div//a[text()='Start Collection']"));
		wb.click();
	}

	
}
