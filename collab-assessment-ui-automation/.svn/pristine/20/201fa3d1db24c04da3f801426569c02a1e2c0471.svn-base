package com.cisco.collabNextGen.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.model.Log;
import com.cisco.collabNextGen.utilities.LoggerLib;
import com.cisco.collabNextGen.utilities.WebDriverUtilities;

public class CommonReusables {

	/**
	 * Logger instance
	 */
	public Logger log = LoggerLib.writeLog(this.getClass().getName());
	WebDriverUtilities webDriveLib= new WebDriverUtilities();
	
	/**
	 *This method is used to switch to the frame to SSUEMAIN 
	 * @param driver 
	 */
	public boolean switchToFrameSSUEMain(WebDriver driver){
		try{
			//log.info("Switching the frame to SSUECONTENT IFRAME");
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ssueContentIframe ng-scope']")));
			//log.info("Sucessfully switched to the frame: SSUECONTENT IFRAME");
		}catch (Exception e) {
			
			e.printStackTrace();
			log.error("Unable to switch to frame");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param driver
	 */
	public boolean switchToFrameSSUEPopUP(WebDriver driver){
		try{
			//log.info("Switching the frame to NGSCOPE SSUE POPUP IFRAME");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ng-scope']")));
		//log.info("Sucessfully switched to the frame: NGSCOPE SSUE POPUP IFRAME");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to switch to frame");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param driver
	 */
	public boolean switchTodefaultFrame(WebDriver driver){
		try{
		//log.info("Switching to the default IFRAME");
		driver.switchTo().defaultContent();
		//log.info("Sucessfully switched to the frame: NGSCOPE SSUE POPUP IFRAME");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to switch to frame");
			return false;
			
		}
		return true;
	}

	/**
	 * This method is used to filter the column in the grid
	 * @param driver
	 * @param coloumnName
	 * @param filter
	 * @throws InterruptedException 
	 */
	public void filterColumn(WebDriver driver, String coloumnName, String filter) throws InterruptedException{
		log.info("Filtering the table with the column- "+coloumnName+" with the value - "+ filter);
		switchToFrameSSUEMain(driver);
		WebElement columnSearch=driver.findElement(By.xpath("//span[text()='"+coloumnName+"']/ancestor::div[@role='columnheader']//input[@aria-label='Filter for column']"));
		columnSearch.clear();
		columnSearch.sendKeys(filter);
		Thread.sleep(1000);
	}
	
	/**
	 * This method is used to filter the column in the grid
	 * @param driver
	 * @param coloumnName
	 * @param filter
	 * @throws InterruptedException 
	 */
	public void filterColumnClear(WebDriver driver, String coloumnName) throws InterruptedException{
		log.info("Clearing the Filter with the column- "+coloumnName);
		switchToFrameSSUEMain(driver);
		WebElement columnSearch=driver.findElement(By.xpath("//span[text()='"+coloumnName+"']/ancestor::div[@role='columnheader']//input[@aria-label='Filter for column']"));
		columnSearch.clear();
		Thread.sleep(1000);
	}
	
	
	
	/**
	 * This returns the Status of the Job/Device Connectivity
	 * 
	 * @param driver
	 * @param attribName
	 * @return
	 * @throws InterruptedException
	 */
	public  String verifyStatus(WebDriver driver, String pageName, String attribName) throws InterruptedException{

		String status = "",actStatus = null;
		int time=0;
		//String pageName= driver.findElement(By.xpath("//div[@class='ssueContainerTitle']/span")).getText();
		if(pageName.contains("Device Connectivity")){
		while(!status.equals("Completed")){

			switchToFrameSSUEMain(driver);
			status=driver.findElement(By.xpath("//div[text()='"+attribName+"']/ancestor::div[contains(@id,'uiGrid')]/following-sibling::div[contains(@class,'connectivity')]")).getAttribute("class").trim();
			actStatus=status.split(" ")[2].trim();
			if(actStatus.equalsIgnoreCase("failure")){
				status="Failed";
				return actStatus;
			}
			if(status.contains("passed")){
				status="Completed";
			}
			
			if(status.contains("connectivitynotdone")){
				status="connectivitynotdone";
				return actStatus;
			}

			driver.switchTo().defaultContent();
			WebElement wb=driver.findElement(By.xpath("//div[@class='AtlanticIcon_module_refresh']"));
			webDriveLib.moveToElementAndClick(driver,wb);
			Thread.sleep(1000);
			time++;
		}
		log.info("Job took approx "+time+" seconds");
		}
		if(pageName.contains("Analysis Jobs")){
			
			while(!status.equals("Completed")){

				switchToFrameSSUEMain(driver);
				status=driver.findElement(By.xpath("//div[text()='"+attribName+"']/ancestor::div[contains(@id,'uiGrid')]/following-sibling::div[contains(@class,'connectivity')]")).getAttribute("class").trim();
				actStatus=status.split(" ")[2].trim();
				if(status.contains("completed")){
					status="Completed";
				}
				

				driver.switchTo().defaultContent();
				WebElement wb=driver.findElement(By.xpath("//div[@class='AtlanticIcon_module_refresh']"));
				webDriveLib.moveToElementAndClick(driver,wb);
				Thread.sleep(1000);
				time++;
			}
			log.info("Approx. time taken for the Job to tbe completed is around "+ time+" sec(s)");
		}
	
	if(pageName.contains("Collection Jobs")){
		
		while(!status.equals("Completed")){

			switchToFrameSSUEMain(driver);
			status=driver.findElement(By.xpath("//a[text()='"+attribName+"']/ancestor::div[contains(@id,'uiGrid')]/following-sibling::div[contains(@class,'connectivity')]")).getAttribute("class").trim();
			actStatus=status.split(" ")[2].trim();
			if(status.contains("completed")){
				status="Completed";
			}
			if(status.contains("completedwitherror")){
				status="Completed";
			}
			if(actStatus.equalsIgnoreCase("failure")){
				status="Failed";
			}
			driver.switchTo().defaultContent();
			WebElement wb=driver.findElement(By.xpath("//div[@class='AtlanticIcon_module_refresh']"));
			webDriveLib.moveToElementAndClick(driver,wb);
			Thread.sleep(1000);
			time++;
		}	
	}
	
	return actStatus;
}
	
/**
 * Compare two lists with String as element 
 * returns false - if size is different
 * returns false - if all the elements are not equal
 * 	
 * @param firstList   List with all the elements as String
 * @param secondList  List with all the elements as String
 * @return  returns boolean   - true if equal/ false if not equal
 */
public boolean compareLists(List<String> firstList, List<String> secondList){
	
		
		if(firstList.size()==secondList.size()){
		Collections.sort(firstList);
		Collections.sort(secondList);
		for(int i=0;i<firstList.size();i++){
			if(!firstList.get(i).equals(secondList.get(i))){
				log.info("List are not equal");
				return false;
			}
		}
		}else{
			log.info("List is not equal as size is different");
			return false;
		}
	
return true;
	}


/**
 * Compare two lists with WebElement as element 
 * returns false - if size is different
 * returns false - if all the elements are not equal
 * 	
 * @param firstList   List with all the elements as String
 * @param secondList  List with all the elements as String
 * @return  returns boolean   - true if equal/ false if not equal
 */
public boolean compareWELists(List<WebElement> firstList, List<WebElement> secondList){
	
	List<String> firtWElist = new LinkedList<>(),secondWElist = new LinkedList<>();
	if(firstList.size()==secondList.size()){
		for(int i=0;i<firstList.size();i++){
			
			firtWElist.add(firstList.get(i).getText().trim());
			secondWElist.add(secondList.get(i).getText().trim());
		}
		
		Collections.sort(firtWElist);
		Collections.sort(secondWElist);
		for(int i=0;i<firtWElist.size();i++){
			if(!firtWElist.get(i).equals(secondWElist.get(i))){
				log.info("List are not equal");
				return false;
			}
		}
		}else{
			log.info("List is not equal as size is different");
			return false;
		}
	
return true;
	}

public List<String> convertListWebElementToString(List<WebElement> listOfWebElement){
	LinkedList<String> lstStr= new LinkedList<>();
	for(int i=0;i<listOfWebElement.size();i++){
		lstStr.add(listOfWebElement.get(i).getText().trim());	
	}
	
	return lstStr;
}

}
