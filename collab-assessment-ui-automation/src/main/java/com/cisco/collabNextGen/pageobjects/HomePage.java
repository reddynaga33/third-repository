
package com.cisco.collabNextGen.pageobjects;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cisco.collabNextGen.common.CommonReusables;
import com.cisco.collabNextGen.common.Constants;
import com.cisco.collabNextGen.common.DriverManager;
import com.cisco.collabNextGen.utilities.LoggerLib;
import com.cisco.collabNextGen.utilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {
	//Logger log = LoggerLib.writeLog(this.getClass().getName());
	public CommonReusables commonRU = new CommonReusables();
	public WebDriverUtilities webDriveLib = new WebDriverUtilities();
	public String defaultAnalysisJob="";
	/**
	 * Logger instance
	 */
	public Logger log = Constants.log;
	
	
	@FindBy(xpath="//div[@class='dropdown-toggle-elem']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//button[@tooltip-html-unsafe='Information']")
	private WebElement infoBtn;
	
	@FindBy(xpath="//span[@class='AtlanticIcon_header_feedback']")
	private WebElement feedbackIcon;
	
	@FindBy(xpath="//button[@tooltip-html-unsafe='Language Selection']")
	private WebElement LanguageIcon;
	
	@FindBy(xpath="//span[@class='icon-help-alt']")
	private WebElement helpIcon;
	
	@FindBy(xpath="//div[@class='ssueLnpToggler AtlanticIcon_header_togglehide']")
	private WebElement navicon;
	
	@FindBy(xpath="//div[@class='AtlanticIcon_module_filter filterIcon']")
	private WebElement filterIcon;
	
	@FindBy(xpath="i[@class='ui-grid-icon-menu']")
	private WebElement UiGridIcon;
	
	@FindBy(xpath="//i[@class='AtlanticIcon_module_search searchIcon']")
	private WebElement searchIcon;
	
	@FindBy(xpath=".//*[contains (text(),'Customer')]")
	private WebElement customerLabel;
	
	@FindBy(xpath="//div[@class='AtlanticIcon_edit ssueDomainFilterEditAction' or  ng-click='edit()']")
	private WebElement editIcon;
	
	@FindBy(xpath=".//h4[contains (text(),'Global Filters')]")
	private WebElement GloablFilterPopupLabel;
	
	@FindBy(xpath=".//div[contains (text(),'Customer')]")
	private WebElement CustomerGlobalFilterPopUp;
	
	@FindBy(xpath=".//div[contains (text(),'Audit Type')]")
	private WebElement AuditTypeGlobalFilterPopUp;
	
	@FindBy(xpath="//span[contains (text(),'Customer & Licensing')]")
	private WebElement CustomerLicensingLNP;
	
	@FindBy(xpath="//span[contains(text(),'Dashboards')]")
	private WebElement DashboardsLabelLNP;
	
	@FindBy(xpath="//span[@class='ssueDashboardCreate AtlanticIcon_add']")
	private WebElement DashboardsAddSymbolLNP;
	
	@FindBy(xpath="//span[text()='Dashboards']/preceding-sibling::span[@class='AtlanticIcon_triangle_close']")
	private WebElement DashboardAngleDownArrowLNP;
	
	@FindBy(xpath="//span[contains(text(),'Library')]")
	private WebElement LibraryLabelLNP;
	
	@FindBy(xpath="//span[text()='Library']/preceding-sibling::span[@class='AtlanticIcon_triangle_close']")
	private WebElement LibraryAngleCloseArrowLNP;
	
	@FindBy(xpath="//span[text()='Library']/preceding-sibling::span[@class='AtlanticIcon_triangle_open']")
	private WebElement LibraryAngleOpenArrowLNP;
	
	@FindBy(xpath="//div[span[text()='Collection']]/preceding-sibling::i[contains(@class,'tree-branch-head treecontrol-arrows AtlanticIcon_triangle_close')]")
	private WebElement CollectionAngleCloseArrowLNP;
	
	
	@FindBy(xpath="//div[span[text()='Collection']]/preceding-sibling::i[contains(@class,'tree-branch-head treecontrol-arrows AtlanticIcon_triangle_open')]")
	private WebElement CollectionAngleOpenArrowLNP;
	
	
	
	@FindBy(xpath="//*[contains(text(), 'Collection')]")

	private WebElement CollectionLNP;
	


	

	
	@FindBy(xpath="//*[contains(text(), 'Device Manager')]")
	private WebElement deviceManagerLnkLNP;
	
	@FindBy(xpath="//*[contains(text(), 'Device Connectivity')]")
	private WebElement DeviceConnectivity;
	
	
	@FindBy(xpath="//*[contains(text(), 'Data Collection')]")
	private WebElement DataCollectionLNP;
	
	@FindBy(xpath="//*[contains(text(), 'Custom Collection Scripts')]")
	private WebElement CustomCollectionScriptsLabel;
	
	@FindBy(xpath="//*[contains(text(), 'Collection Jobs')]")
	private WebElement CollectionJobsLNP;
	
	@FindBy(xpath="//*[contains(text(), 'Analysis')]")
	private WebElement AnalysisLNP;
	
	@FindBy(xpath="//*[contains(text(), 'Data Analysis')]")
	private WebElement DataAnlasysLNP;
	
	@FindBy(xpath="//*[contains(text(), 'Advanced Data Analysis')]")
	private WebElement AdvancedDataAnalysisLNP;
	
	
	@FindBy(xpath="//div[@class='AtlanticIcon_edit ssueDomainFilterEditAction']")
	private WebElement AnalysisJobsLNP;
	
	
	@FindBy(xpath="//span[text()='Reporting']")
	private WebElement ReportingLNP;
	
	
	@FindBy(xpath="//span[text()='Reports']")
	private WebElement Reports;
	
	
	@FindBy(xpath="//span[text()='Custom Reports']")
	private WebElement CustomReports;
	

	@FindBy(xpath="//span[text()='Utilities']")
	private WebElement Utilities;
	

	@FindBy(xpath="//span[text()='Download Logs']")
	private WebElement Downloadlogs;
	
	@FindBy(xpath="//span[text()='Download Usage Analytics']")
	private WebElement DownloadUsageAnalytics;
	
	
	
	
	
	
	@FindBy(xpath="//div[@class='AtlanticIcon_edit ssueDomainFilterEditAction']")
	private WebElement AuditTypeLabel;
	
	
	@FindBy(xpath = "//span[text()='Data Analysis']")
	private WebElement dataAnalysisLNP;
	

	@FindBy(xpath = "//span[text()='Analysis']")
	private WebElement analysisLNP;
	
	@FindBy(xpath = "//div[@class='AtlanticIcon_module_refresh']")
	private WebElement refreshBtn;
	

	
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	public HomePage() {
		
	}



	public void navigateToAnyModule() throws InterruptedException{
		Thread.sleep(2000);
		if( webDriveLib.IsElementDisplayed(LibraryAngleOpenArrowLNP))
		{
			
			webDriveLib.click(LibraryAngleOpenArrowLNP);
		}
		
		Thread.sleep(2000);
		if( webDriveLib.IsElementDisplayed(LibraryAngleCloseArrowLNP))
		{
			
			webDriveLib.click(LibraryAngleCloseArrowLNP);
		}
		
		Thread.sleep(2000);
		if(webDriveLib.IsElementDisplayed(CollectionAngleCloseArrowLNP)){
			webDriveLib.click(CollectionAngleCloseArrowLNP);
			
			
		}
		Thread.sleep(2000);
		if(webDriveLib.IsElementDisplayed(deviceManagerLnkLNP)){
			
			webDriveLib.click(deviceManagerLnkLNP);
			
			
		}
		
	}
	
public void navigateToAnyElement() throws InterruptedException{
		Thread.sleep(2000);
		if(deviceManagerLnkLNP.isDisplayed())
		{
			deviceManagerLnkLNP.click();
				
			
		}
		
		else if(CollectionAngleCloseArrowLNP.isDisplayed())
		{
			Thread.sleep(2000);
			CollectionAngleCloseArrowLNP.click();
			Thread.sleep(2000);
			deviceManagerLnkLNP.click();
				
		}
		
		else
			//LibraryAngleCloseArrowLNP.click();
			//LibraryAngleCloseArrowLNP.click();
		{
		if(CollectionAngleCloseArrowLNP.isDisplayed()){
			Thread.sleep(2000);
			CollectionAngleCloseArrowLNP.click();
			Thread.sleep(2000);
			deviceManagerLnkLNP.click();
			
		}
		else
		{
			deviceManagerLnkLNP.click();
		}
		}
		
	}

	
	public void navigatToAnyModule() throws InterruptedException{
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
		if(webDriveLib.IsElementDisplayed(CollectionAngleCloseArrowLNP)){
			webDriveLib.click(CollectionAngleCloseArrowLNP);
			
			
		}
		Thread.sleep(2000);
		if(webDriveLib.IsElementDisplayed(deviceManagerLnkLNP)){
			
			webDriveLib.click(deviceManagerLnkLNP);
			
			
		}
		
	}
	
	
	


	@FindBy(xpath = "//div[span[text()='Analysis']]//preceding-sibling::i[contains(@class,'arrows')]")
	private WebElement analysisArrow;

	
	public AddDevicePage navigateToDeviceManager(){
		
		deviceManagerLnkLNP.click();
		
		//return PageFactory.initElements(DriverManager.driver, AddDevicePage.class);
		return null;
	}

	public void clickOnModule(WebDriver driver, String moduleName){
		driver.findElement(By.xpath("//div[span[text()='"+moduleName+"']]//preceding-sibling::i[contains(@class,'arrows')]"));
		String status=analysisArrow.getAttribute("class");
		if(status.contains("close")){
			if(moduleName.equalsIgnoreCase("analysis")){
		analysisLNP.click();
			}
			if(moduleName.equalsIgnoreCase("collection")){
				CollectionLNP.click();
			}
			if(moduleName.equalsIgnoreCase("reporting")){
				ReportingLNP.click();
			}
		}
	}
	
	/**
	 * This method can be used for LNP to get the name of the pages/Subsections under any module
	 * Ex- Under Analysis we have Data Analysis, Advance Data Analysis and Analysis Jobs
	 * @param driver         WebDriver - wendriver instance is required
	 * @param moduleName     String - Module name is required to get the pages Ex-  Analysis, Collection, Reporting 
	 * @return
	 */
	public LinkedList getModuleSubSections(WebDriver driver, String moduleName){
		LinkedList<String> lstName= new LinkedList<>();
		List<WebElement> subModules=driver.findElements(By.xpath("//div[span[text()='"+moduleName+"']]/following-sibling::treeitem//li//span[contains(@class,'treecontrolNode')]"));
		for(int i=0;i<subModules.size();i++){
			lstName.add(subModules.get(i).getText().trim());
		}
		
		return lstName;
	}

	public DataAnalysisPage navigateToDataAnalysis(){
		
		dataAnalysisLNP.click();
		return PageFactory.initElements(DriverManager.driver, DataAnalysisPage.class);

	}
	
	

}
