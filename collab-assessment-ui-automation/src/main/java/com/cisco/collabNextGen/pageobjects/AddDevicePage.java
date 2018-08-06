package com.cisco.collabNextGen.pageobjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cisco.collabNextGen.common.DriverManager;

public class AddDevicePage extends HomePage {
	public static String str="";
	//span[contains(text(),'Collection')]
	@FindBy(xpath="//ssue-lnp/div[4]/sticky-scroll/treecontrol/ul/li[1]/i[1]")
	private WebElement collectorLink;
	
	
	@FindBy( xpath ="//sticky-scroll/treecontrol/ul/li[1]/treeitem/ul/li[1]/div/span")
	private WebElement deviceManager;
	@FindBy( xpath ="//span[@translate='ACTIONS']")
	private WebElement actionBtn;

	@FindBy( xpath =".//*[contains (text(),'Add Device')]")
	private WebElement adddeviceBtn;

	@FindBy(id="version")
	private WebElement versionBoxDropdown;
	
	//@FindBy( xpath =".//*[@id='version']/option[9]")
	private WebElement deviceVersion;
	
	@FindBy(id="name")
	private WebElement displayname;
	
	@FindBy(id="ipAddress")
	private WebElement ipAddress;
	
	@FindBy(id="winAdminUsername")
	private WebElement appAdminUsername;
	
	@FindBy( id = "winAdminPassword")
	private WebElement appAdminPassword;
	
	@FindBy( id ="cliUsername")
	private WebElement cliUsername;
	
	@FindBy( name ="cliPassword")
	private WebElement cliPassword;
	
	@FindBy( name ="localIpAddress")
	private WebElement localIpAddress;
	
	@FindBy( xpath ="//form/div[2]/button[2]")
	private WebElement addAndTestConnectivity;
	
	@FindBy(xpath="//iframe[@class='ssueContentIframe ng-scope']")
	private WebElement iframe;
	
	@FindBy(xpath="//iframe[@class='ng-scope']")
	private WebElement iframePopUp;
	
	
	
	public AddDevicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addDevice_And_Test(String deviceName) throws InterruptedException
	{
		Thread.sleep(10000);
		if (deviceManager.isDisplayed()==false){
	collectorLink.click();
	log.info("Clicked on Collection link");
	}
	Thread.sleep(2000);
	deviceManager.click();
	log.info("Clicked on Device manager");
	Thread.sleep(5000);
	switchToFrameSSUEMain(DriverManager.getTheDriverInstance());
	log.info("Switched to frame");
	Thread.sleep(5000);
	actionBtn.click();
	log.info("Clicked on action button ");
	Thread.sleep(3000);
	adddeviceBtn.click();
	log.info("Clicked on Adddevice link");
	switchToFrameSSUEPopup(DriverManager.getTheDriverInstance());
	Thread.sleep(3000);
		//versionBox.clear();
	//versionBoxDropdown.click();
	//deviceVersion.click();
	
	selectByVisibleText(versionBoxDropdown, "10.5");
	
		log.info("version selected");
		displayname.clear();
		str = deviceName+random();
		log.info("devicename append with random number");
		displayname.sendKeys(str);
		log.info("Display name entered");
		ipAddress.clear();
		//ipAddress.sendKeys("10."+random()+".3."+random());
		ipAddress.sendKeys("10.106.2.71");
		log.info("IP address entered");
		appAdminUsername.clear();
		appAdminUsername.sendKeys("administrator");//administrator
		log.info("Entered application password");
		appAdminPassword.clear();
		appAdminPassword.sendKeys("c1sc0123");//c1sc0123
		log.info("application pasword is entered");
		cliUsername.clear();
		cliUsername.sendKeys("administrator");//administrator
		log.info("Platform username entered");
		cliPassword.clear();
		cliPassword.sendKeys("c1sc0123");//Collab321#
		log.info("Application password enetered");
		localIpAddress.clear();
		localIpAddress.sendKeys("1.1.1.1");
		log.info("Local IP address entered ");
		
		Thread.sleep(3000);
		addAndTestConnectivity.click();
		log.info("Clicked on add device and test connectivity button");
		Thread.sleep(5000);
		
	}

	
	public void switchToFrameSSUEMain(WebDriver driver){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframe);
		}
	
	public void switchToFrameSSUEPopup(WebDriver driver){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframePopUp);
		}
	
	public String getDeviceName()
	{
		return displayname.getText();
	}
	
	public int random()
	{
		Random rn = new Random();
		int num=rn.nextInt(100);
		log.info("Random number generated");
		return num;
		
	}
//	WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""));
//	));
}


