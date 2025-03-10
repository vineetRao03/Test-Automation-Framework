package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippmentPage  extends BrowserUtility{
	
	private static final By TERMS_OF_SERVICE_CLICKBOX_LOCATOR=By.xpath("//div[@class='checker']");
	private static final By PROCEED_TO_CHECKOUT = By.name("processCarrier");
	private ShippmentPage shippmentPage;

	public ShippmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public PaymentPage goToPaymentMode() {
		clickOnCheckBox(TERMS_OF_SERVICE_CLICKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT);
		return new PaymentPage(getDriver());
	}
	
}
