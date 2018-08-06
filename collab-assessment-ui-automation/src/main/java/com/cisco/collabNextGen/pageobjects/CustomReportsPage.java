package com.cisco.collabNextGen.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomReportsPage {
	
	
	@FindBy(xpath="//a[contains(text(), 'Download')]")
	private WebElement downloadLNK ;
	
	@FindBy(xpath="//a[contains(text(), 'Edit')]")
	private WebElement EditLNK;

}
