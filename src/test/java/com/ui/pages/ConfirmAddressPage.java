package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility {

	private static final By PROCEED_TO_CHECKOUT= By.name("processAddress");
	
	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
	}
	
	public ShippmentPage goToShipmentPage() {
		
		clickOn(PROCEED_TO_CHECKOUT);
		return new ShippmentPage(getDriver());
	}

}
