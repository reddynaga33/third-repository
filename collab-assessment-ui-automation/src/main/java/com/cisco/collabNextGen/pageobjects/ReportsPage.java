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

public class ReportsPage extends HomePage {

	
	public ReportsPage() {
		super(driver);
		// TODO Auto-generated constructor stub
	}




	CommonReusables commonRU = new CommonReusables();
	WebDriverUtilities webDriveLib= new WebDriverUtilities();
	/**
	 * Logger instance
	 */
	public Logger log = LoggerLib.writeLog(this.getClass().getName());



	@FindBy(xpath = "//a[contains(text(),'Download')]")
	private WebElement downloadLNK;
	
	@FindBy(xpath = "//a[contains(text(),'Customize')]")
	private WebElement CustomizeLNK;

	@FindBy(xpath = "//span[text()='All formats in compressed file']/preceding-sibling::span")
	private WebElement allFormatPopupCkBx;

	@FindBy(xpath = "//div[contains(@class,'quickdownloadModal')]//button[text()='Download']")
	private WebElement downloadBtnPopup;
	


	@FindBy(xpath="//div[span[text()='Reporting']]/preceding-sibling::i[@class='tree-branch-head treecontrol-arrows AtlanticIcon_triangle_close']")
	private WebElement ReportingAngleCloseArrowLNP;


	/**
	 * This method is used to download the report with given AnalysisjobName and Report Format
	 * 
	 *	IMPLEMENTATION PENDING FOR WORD/PPT DOWNLOAD
	 * @param driver
	 * @param analysisJobName
	 * @param reportFormat
	 * @return
	 * @throws InterruptedException
	 */
	public boolean downloadReport(WebDriver driver,String analysisJobName,String reportFormat) throws InterruptedException{
		log.info("In the Reporting Page");
		commonRU.switchToFrameSSUEMain(driver);
		commonRU.filterColumn(driver, "Analysis Job", analysisJobName);
		Thread.sleep(3000);
		webDriveLib.moveToElementAndClick(driver, driver.findElement(By.xpath("//div[div[text()='"+analysisJobName+"']]/following-sibling::div//a[contains(text(),'Download')]")));
		//driver.findElement(By.xpath("//div[div[text()='"+analysisJobName+"']]/following-sibling::div//a[contains(text(),'Download')]"));
		//downloadLNK.click();
		Thread.sleep(2000);
		if(reportFormat.equalsIgnoreCase("All")){
			WebElement wb=driver.findElement(By.xpath("//span[text()='All formats in compressed file']/preceding-sibling::span"));
			webDriveLib.moveToElementAndClick(driver, wb);
			log.info("Download the report");
			WebElement wb1=driver.findElement(By.xpath("//div[contains(@class,'quickdownloadModal')]//button[text()='Download']"));
			wb1.click();
			log.info("Sucessfully Downloaded");
		}
		if(reportFormat.equalsIgnoreCase("doc")){
			WebElement wb=driver.findElement(By.xpath("//span[text()='All formats in compressed file']/preceding-sibling::span"));
			webDriveLib.moveToElementAndClick(driver, wb);
			log.info("Download the report");
			WebElement wb1=driver.findElement(By.xpath("//div[contains(@class,'quickdownloadModal')]//button[text()='Download']"));
			wb1.click();
			log.info("Sucessfully Downloaded");
		}if(reportFormat.equalsIgnoreCase("ppt")){
			WebElement wb=driver.findElement(By.xpath("//span[text()='All formats in compressed file']/preceding-sibling::span"));
			webDriveLib.moveToElementAndClick(driver, wb);
			log.info("Download the report");
			WebElement wb1=driver.findElement(By.xpath("//div[contains(@class,'quickdownloadModal')]//button[text()='Download']"));
			wb1.click();
			log.info("Sucessfully Downloaded");
		}
		return true;


	
	
	
    /**
    * This method is used to download the report with given AnalysisjobName and Report Format
    * 
     *    IMPLEMENTATION PENDING FOR WORD/PPT DOWNLOAD
    * @param driver
    * @param analysisJobName
    * @param reportFormat
    * @return
    * @throws InterruptedException
    */
    public boolean downloadReport(WebDriver driver,String analysisJobName,String reportFormat) throws InterruptedException{
           log.info("In the Reporting Page");
           commonRU.switchToFrameSSUEMain(driver);
           commonRU.filterColumn(driver, "Analysis Job", analysisJobName);
           Thread.sleep(3000);
           webDriveLib.moveToElementAndClick(driver, driver.findElement(By.xpath("//div[div[text()='"+analysisJobName+"']]/following-sibling::div//a[contains(text(),'Download')]")));
    //driver.findElement(By.xpath("//div[div[text()='"+analysisJobName+"']]/following-sibling::div//a[contains(text(),'Download')]"));
           //downloadLNK.click();
           Thread.sleep(2000);
           if(reportFormat.equalsIgnoreCase("All")){
                 WebElement wb=driver.findElement(By.xpath("//span[text()='All formats in compressed file']/preceding-sibling::span"));
                 webDriveLib.moveToElementAndClick(driver, wb);
                 log.info("Download the report");
                 WebElement wb1=driver.findElement(By.xpath("//div[contains(@class,'quickdownloadModal')]//button[text()='Download']"));
                 wb1.click();
                 log.info("Sucessfully Downloaded");
           }
           if(reportFormat.equalsIgnoreCase("doc")){
                 WebElement wb=driver.findElement(By.xpath("//span[@class='checkbox__input text-small']/following-sibling::span[text()='Microsoft Word (Doc)']"));
                 webDriveLib.moveToElementAndClick(driver, wb);
                 log.info("Download the report");
                 WebElement wb1=driver.findElement(By.xpath("//div[contains(@class,'quickdownloadModal')]//button[text()='Download']"));
                 wb1.click();
                 log.info("Sucessfully Downloaded");
           }if(reportFormat.equalsIgnoreCase("ppt")){
                 WebElement wb=driver.findElement(By.xpath("//span[@class='checkbox__input text-small']/following-sibling::span[text()='Executive Summary PowerPoint (PPT)']"));
                 webDriveLib.moveToElementAndClick(driver, wb);
                 log.info("Download the report");
                 WebElement wb1=driver.findElement(By.xpath("//div[contains(@class,'quickdownloadModal')]//button[text()='Download']"));
                 wb1.click();
                 log.info("Sucessfully Downloaded");
           }
           return true;
    }

}
