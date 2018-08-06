package com.cisco.collabNextGen.pageobjects;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cisco.collabNextGen.common.CommonReusables;
import com.cisco.collabNextGen.utilities.LoggerLib;
import com.cisco.collabNextGen.utilities.WebDriverUtilities;


public class DataAnalysisPage  extends HomePage{
	CommonReusables commonRU = new CommonReusables();
	WebDriverUtilities webDriveLib= new WebDriverUtilities();
	public String defaultAnalysisJob="";
	/**
	 * Logger instance
	 */
	public Logger log = LoggerLib.writeLog(this.getClass().getName());

	@FindBy(xpath="//a[@class='analysis_home_select ng-scope']")
	private WebElement selectCollectionJobsWE;

	@FindBy(xpath="//input[@id='text2']")
	private WebElement analysisJobNameEdt;

	@FindBy(xpath="//select[@name='ruleProfile']")
	private WebElement ruleProfileDD;

	@FindBy(xpath="//button[text()='Start Analysis']")
	private WebElement startAnalysisBtn;

	@FindBy(xpath="//button[text()='Close']")
	private WebElement closeBtnPopup;
	
	@FindBy(xpath="//button[text()='Select']")
	private WebElement selectBtnPopup;

	@FindBy(xpath="//span[contains(@ng-if,'sameTaskName')]")
	private WebElement alreadyExistsMsg;
	//span[contains(@ng-if,'sameTaskName')]

	@FindBy(xpath="//div[contains(@class,'text-danger')]//span")
	private List<WebElement> mandatoryErrorMsgs;

	@FindBy(xpath="//i[@aria-label='Grid Menu']")
	private WebElement sortMenuPopup;

	@FindBy(xpath="//div[@class='modal-dialog modal-xsmall']//span[@class='text-small']/i")
	private WebElement messageInCollectionJobPopup;

	@FindBy(xpath="//label[@name='data_set_name']")
	private WebElement collectionJobAfterSelected;

	public WebElement getCollectionJobAfterSelected() {
		return collectionJobAfterSelected;
	}


	public WebElement getMessageInCollectionJobPopup() {
		return messageInCollectionJobPopup;
	}


	public WebElement getCloseBtnPopup() {
		return closeBtnPopup;
	}


	public CommonReusables getCommonRU() {
		return commonRU;
	}


	public WebDriverUtilities getWebDriveLib() {
		return webDriveLib;
	}


	public String getDefaultAnalysisJob() {
		return defaultAnalysisJob;
	}


	public Logger getLog() {
		return log;
	}


	public WebElement getSelectCollectionJobsWE() {
		return selectCollectionJobsWE;
	}


	public WebElement getAnalysisJobNameEdt() {
		return analysisJobNameEdt;
	}


	public WebElement getRuleProfileDD() {
		return ruleProfileDD;
	}


	public WebElement getStartAnalysisBtn() {
		return startAnalysisBtn;
	}


	public WebElement getSelectBtnPopup() {
		return selectBtnPopup;
	}


	public WebElement getAlreadyExistsMsg() {
		return alreadyExistsMsg;
	}


	public List<WebElement> getMandatoryErrorMsgs() {
		return mandatoryErrorMsgs;
	}


	public WebElement getSortMenuPopup() {
		return sortMenuPopup;
	}


	public WebElement getResetBtn() {
		return resetBtn;
	}

	@FindBy(xpath="//button[text()='Reset']")
	private WebElement resetBtn;

	public DataAnalysisPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	/**
	 *Will click on Reset Button assuming frame handing has been done
	 */
	public void clickOnResetBtn(){
		resetBtn.click();
	}

	public boolean verifyResetFunctionality(){
		boolean collectionJob =  false,ruleProfileDDFlag = false, analysisJobFlag = false;

		try{
			collectionJob=selectCollectionJobsWE.isDisplayed();
		}catch(Exception e){
			collectionJob=false;
		}
		Select sel = new Select(ruleProfileDD);
		List<WebElement> options=sel.getAllSelectedOptions();
		if(options.get(0).getText().equals("") && options.size()==1){
			ruleProfileDDFlag=true;
		}
		String x=analysisJobNameEdt.getAttribute("value");
		if(x.equals("")){
			analysisJobFlag=true;
		}
		return collectionJob && ruleProfileDDFlag && analysisJobFlag;
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public List<String> getAllMandatoryFields(WebDriver driver){
		navigateToDataAnalysis();
		commonRU.switchToFrameSSUEMain(driver);
		startAnalysisBtn.click();
		List lstMessages=new LinkedList<>();
		List<WebElement> mandatoryMsgs=mandatoryErrorMsgs;
		for(int i=0;i<mandatoryMsgs.size();i++){
			lstMessages.add(mandatoryMsgs.get(i).getText());
		}
		return lstMessages;
	}
	/**
	 * This method is used to enter all the data in the fields present in the Data Analysis Page
	 * If Analysis Job is passed parameter as Default then it will assume the default Analysis Job Name
	 * @param driver
	 * @param collectionJob
	 * @param analysisJob
	 * @param ruleProfile
	 * @throws InterruptedException
	 */
	public void enterAllFields(WebDriver driver,String collectionJob, String analysisJob, String ruleProfile) throws InterruptedException{
		navigateToDataAnalysis();
		commonRU.switchToFrameSSUEMain(driver);
		log.info("Select the Collection Jobs");
		selectCollectionJobsWE.click();
		log.info("Collection Jobs Filter");
		commonRU.filterColumn(driver, "Collection Jobs", collectionJob);
		log.info("Selecting the Collection "+collectionJob);
		driver.findElement(By.xpath("//div[text()='"+collectionJob+"']")).click();
		log.info("Clicking the select button");
		selectBtnPopup.click();
		log.info("Input Analysis Job Name");
		if(!analysisJob.equalsIgnoreCase("Default")){
			analysisJobNameEdt.clear();
			analysisJobNameEdt.sendKeys(analysisJob);		
		}

		defaultAnalysisJob=analysisJobNameEdt.getAttribute("value");
		log.info("Select Rule Profile");
		webDriveLib.selectByVisibleText(ruleProfileDD, ruleProfile);
		Thread.sleep(2000);

	}

	public boolean startAnalysis(WebDriver driver,String collectionJob, String analysisJob, String ruleProfile) throws InterruptedException{
		//String collectionJob="CUCM_9_1_101_task_1";
		//String analysisJob="Testing123";
		//String CUCMAUDITTYPE="CUCM Config";
		defaultAnalysisJob=analysisJob;
		try {
			navigateToDataAnalysis();
			commonRU.switchToFrameSSUEMain(driver);
			log.info("Select the Collection Jobs");
			selectCollectionJobsWE.click();
			log.info("Collection Jobs Filter");
			commonRU.filterColumn(driver, "Collection Jobs", collectionJob);
			log.info("Selecting the Collection "+collectionJob);
			driver.findElement(By.xpath("//div[text()='"+collectionJob+"']")).click();
			log.info("Clicking the select button");
			selectBtnPopup.click();
			log.info("Input Analysis Job Name");
			analysisJobNameEdt.clear();
			analysisJobNameEdt.sendKeys(analysisJob);
			//defaultAnalysisJob=analysisJobNameEdt.getAttribute("value");
			log.info("Select Rule Profile");
			webDriveLib.selectByVisibleText(ruleProfileDD, ruleProfile);
			Thread.sleep(2000);
			log.info("Start Analysis");
			startAnalysisBtn.click();
			Thread.sleep(1500);
			try{while(alreadyExistsMsg.isDisplayed()){
				log.info("Analysis Job Name already exists");
				Random random = new Random();
				random.nextInt();
				analysisJobNameEdt.sendKeys(random.nextInt()+"");
				defaultAnalysisJob=analysisJobNameEdt.getAttribute("value");
				startAnalysisBtn.click();
			}}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			log.info("Analysis has been started Sucesfully");
		} catch (Exception e) {

			log.error("Error in Performing Start Analysis");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/*	public boolean startAnalysis(WebDriver driver, String analysisJobName) throws InterruptedException{
		String collectionJob="CUCM_9_1_101_task_1";
		String analysisJob=analysisJobName;
		String CUCMAUDITTYPE="CUCM Config";
		try {
			commonRU.switchToFrameSSUEMain(driver);
			log.info("Select the Collection Jobs");
			selectCollectionJobsWE.click();
			log.info("Collection Jobs Filter");
			commonRU.filterColumn(driver, "Collection Jobs", collectionJob);
			log.info("Selecting the Collection "+collectionJob);
			driver.findElement(By.xpath("//div[text()='"+collectionJob+"']")).click();
			log.info("Clicking the select button");
			selectBtnPopup.click();
			log.info("Input Analysis Job Name");
			analysisJobNameEdt.clear();
			analysisJobNameEdt.sendKeys(analysisJob);
			log.info("Select Rule Profile");
			webDriveLib.selectByVisibleText(ruleProfileDD, CUCMAUDITTYPE);
			Thread.sleep(2000);
			log.info("Start Analysis");
			startAnalysisBtn.click();
			log.info("Analysis has been started Sucesfully");
		} catch (Exception e) {

			log.error("Error in Performing Start Analysis");
			e.printStackTrace();
			return false;
		}

		return true;
	}
	 */
	/**
	 * 
	 * @param driver
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean verifyMenuWithGrid(WebDriver driver) throws InterruptedException{
		boolean result;
		Thread.sleep(2000);
		getSelectCollectionJobsWE().click();
		commonRU.switchToFrameSSUEMain(driver);
		log.info("Select the Collection Jobs");
		List<WebElement> columnHeader= driver.findElements(By.xpath("//span[contains(@id,'header-text')]"));
		sortMenuPopup.click();
		List<WebElement> menuList=driver.findElements(By.xpath("//ul[@class='ui-grid-menu-items']//i[@class='ui-grid-icon-ok']/ancestor::button"));

		result=commonRU.compareWELists(menuList, columnHeader);
		sortMenuPopup.click();
		closeBtnPopup.click();
		return result;
	}

	public boolean verifyFilterInPopup(WebDriver driver) throws InterruptedException{
		getSelectCollectionJobsWE().click();
		Thread.sleep(2000);
		List<WebElement> firstRow=driver.findElements(By.xpath("//div[@class='ui-grid-row ng-scope'][2]//div[contains(@class,'cell-contents')]"));
		List<WebElement> columnHeader= driver.findElements(By.xpath("//span[contains(@id,'header-text')]"));
		List<String> dataList=commonRU.convertListWebElementToString(firstRow);
		List<String> columnHeaderList=commonRU.convertListWebElementToString(columnHeader);

		for(int i=0;i<firstRow.size();i++){
			commonRU.filterColumn(driver, columnHeaderList.get(i), dataList.get(i));
			Thread.sleep(2000);
			//			List<WebElement> afterSelected=driver.findElements(By.xpath("//div[contains(@class,'row-selected')]//div[contains(@class,'ui-grid-cell-contents')]"));
			String s = dataList.get(i);
			if(!driver.findElement(By.xpath("//div[text()='"+s+"']")).isDisplayed()){
				return false;
			}
			//			if(!afterSelected.get(i).getText().trim().equalsIgnoreCase(firstRow.get(i).getText())){
			//				return false;
			//			}
			commonRU.filterColumnClear(driver, columnHeader.get(i).getText().trim());
		}
		closeBtnPopup.click();
		return true;
	}

	public void selectCollectionJob(WebDriver driver, String collectionJob) throws InterruptedException{

		commonRU.switchToFrameSSUEMain(driver);
		log.info("Select the Collection Jobs");
		selectCollectionJobsWE.click();
		log.info("Collection Jobs Filter");
		commonRU.filterColumn(driver, "Collection Jobs", collectionJob);
		log.info("Selecting the Collection "+collectionJob);
		driver.findElement(By.xpath("//div[text()='"+collectionJob+"']")).click();
		log.info("Clicking the select button");
		selectBtnPopup.click();
	}
	public void changeCollectionJob(WebDriver driver, String collectionJob) throws InterruptedException{

		commonRU.switchToFrameSSUEMain(driver);
		log.info("Select the Collection Jobs");
		driver.findElement(By.xpath("//a[text()='Change']")).click();
		log.info("Collection Jobs Filter");
		commonRU.filterColumn(driver, "Collection Jobs", collectionJob);
		log.info("Selecting the Collection "+collectionJob);
		driver.findElement(By.xpath("//div[text()='"+collectionJob+"']")).click();
		log.info("Clicking the select button");
		selectBtnPopup.click();
	}
		
	
	public void getAllTimes(WebDriver driver){
		selectCollectionJobsWE.click();
		commonRU.switchToFrameSSUEMain(driver);
		//verifyAllColumnsSelectedInPopup(driver);
		List<WebElement> times=driver.findElements(By.xpath("//div[contains(@class,'viewport')]//div[contains(@id,'cell')][4]"));
		List<String> timesStringLst=commonRU.convertListWebElementToString(times);
		System.out.println(timesStringLst);
		List<String> backup = timesStringLst;
		Collections.sort(timesStringLst);
		
	}

	public void verifyAllColumnsSelectedInPopup(WebDriver driver){
		
		sortMenuPopup.click();
		List<WebElement> menuList=driver.findElements(By.xpath("//i[@class='ui-grid-icon-ok']"));
		for(int i=0;i<menuList.size();i++){
			String xyz =menuList.get(i).findElement(By.xpath("//ancestor::button")).getAttribute("class");
			System.out.println(xyz);
		}
//		WebElement new1=menuList.findElement(By.xpath("//ancestor::button"));
//		String xyz=new1.getAttribute("class");
	}
}
