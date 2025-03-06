package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOld {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); // Browser Session is created!!

		/*
		 * Initially wrote these 3 lines By passwordTextBoxLocator=By.id("passwd");
		 * WebElement passwordTextBoxElement=wd.findElement(passwordTextBoxLocator);
		 * passwordTextBoxElement.sendKeys("password");
		 * 
		 */

		/*
		 * BrowserUtility browserUtility = new BrowserUtility(wd);
		 * browserUtility.goToWebsite("http://www.automationpractice.pl");
		 * browserUtility.maximizeWindow();
		 * 
		 * By signInLinkLocator = By.xpath("//a[contains(text(),\"Sign in\")]");
		 * browserUtility.clickOn(signInLinkLocator);
		 * 
		 * By emailTextBoxLocator = By.id("email");
		 * browserUtility.enterText(emailTextBoxLocator, "kiliwaf467@codverts.com");
		 * 
		 * By passwordTextBoxLocator = By.id("passwd");
		 * browserUtility.enterText(passwordTextBoxLocator, "password");
		 * 
		 * By submitLoginButtonLocator = By.id("SubmitLogin");
		 * browserUtility.clickOn(submitLoginButtonLocator);
		 */
	}
}
