package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{

	private static final By USER_NAME_LOCATOR=By.xpath("//a[@class='account']/span");

	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}

}
