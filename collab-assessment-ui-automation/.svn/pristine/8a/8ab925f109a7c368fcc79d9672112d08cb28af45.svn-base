package com.cisco.collabNextGen.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cisco.collabNextGen.common.Constants;

public class Testing {
	
	public static void main (String args[]) throws InterruptedException{
		WebDriver driver1;
		System.setProperty("webdriver.gecko.driver", Constants.BROWSERDRIVERFOLDERLOCATION+"\\geckodriver.exe");
		driver1= new FirefoxDriver();
		driver1.get("http://10.127.102.186/ssue/smartconnection/");
		Thread.sleep(5000);
		WebElement ele= driver1.findElement(By.xpath("//sticky-scroll/treecontrol/ul/li[1]/treeitem/ul/li[1]/div/span"));
		if (ele.isDisplayed()==false){
			driver1.findElement(By.xpath("//sticky-scroll/treecontrol/ul/li[1]/i[1]")).click();
			
		}
		else {
			ele.click();
		}
		Thread.sleep(5000);
		WebElement iFrame= driver1.findElement(By.className("ssueContentIframe ng-scope"));
		driver1.switchTo().frame(iFrame);
		//driver1.switchTo().frame(0);//"http://10.127.102.186/ssue/smartreport/index.html#/Device_Connectivity");
		//driver1.findElement(By.cssSelector(".ui-grid-selection-row-header-buttons.ui-grid-icon-ok")).click();
		
		driver1.findElement(By.xpath("//*[contains(text(),'Actions')]"));
				//div[@class='toolbar']/div[@class='dropdown']/div[@class='dropdown-toggle']//span[@translate='ACTIONS']")).click();
		Thread.sleep(2000);
		
	}

}
